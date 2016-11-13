import java.util.*;
public class spiral_matrix {
	public static void main(String[] args) {
		int r=3,c=6;
		int[][]arr = new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
		spiralPrint(r,c,arr);
	}
	static void spiralPrint(int r,int c,int[][]arr){
		int i = 0;//starting row index
		int j = 0;//starting column
		int m = r;
		int n = c;
		while(i<m && j<n){
			//first row
			for(int k=j;k<n;k++){
				System.out.print(arr[i][k]+" ");
			}
			i++;
			//last column
			for(int k=i;k<m;k++){
				System.out.print(arr[k][n-1]+" ");
			}
			n--;
			//last row
			if(i<m){
				for(int k=n-1;k>=j;k--){
					System.out.print(arr[m-1][k]+" ");
				}
				m--;
			}
			//First column
			if(j<n){
				for(int k=m-1;k>=i;k--){
					System.out.print(arr[k][j]+" ");
				}
				j++;
			}
		}
	}
}
