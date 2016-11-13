import java.util.*;
public class lock_key {
	public static void main(String[] args) {
		char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
		helper(nuts,bolts,0,5);
		System.out.println("Matched nuts and bolts are : ");
		printArray(nuts);
		printArray(bolts);
	}
	static void printArray(char[]arr){
		for(char c : arr)System.out.print(c+" ");
		System.out.println();
	}
	static void helper(char[]nuts,char[]bolts,int low,int high){
		if(low<high){
			int pivot = partition(nuts,low,high,bolts[high]);
			partition(bolts,low,high,nuts[pivot]);
			
			helper(nuts,bolts,low,pivot-1);
			helper(nuts,bolts,pivot+1,high);
		}
	}
	static int partition(char[]arr,int low,int high,char pivot){
		int i = low;
		char tmp1,tmp2;
		for(int j=low;j<high;j++){
			if(arr[j]<pivot){
				tmp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp1;
				i++;
			}
			else if(arr[j]==pivot){
				tmp1 = arr[j];
				arr[j] = arr[high];
				arr[high] = tmp1;
				j--;
			}
		}
		tmp2 = arr[i];
		arr[i] = arr[high];
		arr[high] = tmp2;
		return i;
	}
}
