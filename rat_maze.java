import java.util.*;
public class rat_maze {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][]arr = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j] = in.nextInt();
			}
		}
		int[][]sol = new int[n][n];
		helper(arr,0,0,sol);
		print(sol);
	}
	static void print(int[][]arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	static boolean helper(int[][]arr,int x,int y,int[][]sol){
		int n = arr.length;
		if(x==n-1 && y==n-1){
			sol[x][y] = 1;
			return true;
		}
		if(isSafe(arr,x,y)){
			sol[x][y] = 1;
			if(helper(arr,x+1,y,sol))return true;
			if(helper(arr,x,y+1,sol))return true;
			sol[x][y] = 0; //backtrack
		}
		return false;
	}
	static boolean isSafe(int[][]arr,int x,int y){
		int n = arr.length;
		return (x>=0 && x<n && y>=0 && y<n && arr[x][y]==1);
	}
}
