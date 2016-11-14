import java.math.BigInteger;
import java.util.*;

public class Factorial_Large {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String ans = fact(n);
		System.out.println(ans);
		/*int[]arr = new int[5000000];
		arr[0] = 1;
		int res_size = 1;
		for(int i=2;i<=n;i++){
			res_size = mult(i,arr,res_size);
		}
		for(int i = res_size-1;i>=0;i--)System.out.print(arr[i]);
		System.out.println();*/
	}
	static int mult(int x,int[]arr,int res_size){
		int carry = 0;
		for(int i=0;i<res_size;i++){
			int prod = arr[i]*x+carry;
			arr[i] = prod%10;
			carry = prod/10;
		}
		while(carry>0){
			arr[res_size++] = carry%10;
			carry/=10;
		}
		return res_size;
	}
	static String fact(int n){
		BigInteger fact = new BigInteger("1");
	       for (int i = 1; i <= n; i++) {
	           fact = fact.multiply(BigInteger.valueOf(i));
	       }
	       return fact.toString();
	}
}
