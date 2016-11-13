import java.util.*;
public class snake_ladder {
	public static void main(String[] args) {
		int n =30;
		int[]moves = new int[n];
		for(int i=0;i<n;i++)moves[i] = -1;
		//ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;
		
		//snake
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;
		
		minimum(moves,n);
	}
	static void minimum(int[]moves,int n){
		LinkedList<Node> queue = new LinkedList<>();
		boolean[]visited = new boolean[n];
		Node q = new Node(0,0);
		queue.add(q);
		visited[0] = true;
		while(!queue.isEmpty()){
			Node tmp = queue.getFirst();
			
			if(tmp.v == n-1){
				System.out.println("Minimum distance is :  "+tmp.d);
				break;
			}
			queue.removeFirst();
			int v = tmp.v;
			
			for(int j=v+1;j<=(v+6)&&j<n;j++){
				Node qe = new Node();
				if(!visited[j]){
					visited[j] = true;
					if(moves[j]!=-1){
						qe.v = moves[j];
						qe.d = tmp.d+1;
					}else{
						qe.v = j;
						qe.d = tmp.d+1;
					}
					queue.addLast(qe);
					
				}
					
			}
		}
	}
}
class Node{
	int v;
	int d;
	public Node(){};
	public Node(int v,int d){
		this.v = v;
		this.d = d;
	}
}