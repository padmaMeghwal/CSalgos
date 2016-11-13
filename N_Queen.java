import java.util.*;
public class N_Queen {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][]arr = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)arr[i][j] = 0;
		}
		if(solveNQ(arr,0)){
			printMatrix(arr);
		}
	}
	static void printMatrix(int[][]arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean solveNQ(int[][]arr,int col){
		int n = arr.length;
		if(col >= n)return true;
		for(int i=0;i<n;i++ ){
			if(isSafe(arr,i,col)){
				arr[i][col] = 1;
				if(solveNQ(arr,col+1))return true;
				arr[i][col] = 0;
			}
		}
		return false;
	}
	static boolean isSafe(int[][]arr,int row,int col){
		for(int i=0;i<col;i++){
			if(arr[row][i]==1)return false;
		}
		for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			if(arr[i][j]==1)return false;
		}
		int n = arr.length;
		for(int i=row,j=col;i<n && j>=0;i++,j--){
			if(arr[i][j]==1) return false;
		}
		return true;
	}
}
