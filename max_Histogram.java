import java.util.*;
public class max_Histogram {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[]arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		int ans = getMaxArea(arr,n);
		System.out.println(ans);
	}
	static int getMaxArea(int[]arr,int n){
		Stack<Integer>st = new Stack<>();
		int i=0;
		int max_area = 0;
		while(i<n){
			if(st.isEmpty() || arr[st.peek()]<=arr[i])st.push(i++);
			else{
				int tp = st.pop();
				int area = arr[tp]*(st.isEmpty()?i:i-st.peek()-1);
				if(max_area<area)max_area = area;
			}
		}
		
		while(!st.isEmpty()){
			int tp = st.pop();
			int area = arr[tp]*(st.isEmpty()?i:i-st.peek()-1);
			if(max_area<area)max_area = area;
		}
		return max_area;
	}
}