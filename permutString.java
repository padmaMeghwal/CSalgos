import java.util.*;
public class permutString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		permute(str.toCharArray(),0,str.length()-1);
	}
	static void permute(char[]arr,int l,int r){
		if(l==r){
			String string = Arrays.toString(arr);
			System.out.print(string+", ");
		}
		else{
			for(int i=l;i<=r;i++){
				swap(arr,i,l);
				permute(arr,l+1,r);
				swap(arr,i,l);
			}
		}
	}
	static void swap(char[]arr,int i,int j){
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}
