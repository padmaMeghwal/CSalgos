import java.util.*;
public class serialize_deserialize {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		LinkedList<TreeNode>list = new LinkedList<>();
		System.out.println("After serialization");
		serialize(root,list);
		System.out.println("\nAfter de-serialization");
		root = deserialize(null,list);
		inorder(root);
		System.out.println();
	}
	static void inorder(TreeNode root){
		if(root==null)return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	static TreeNode deserialize(TreeNode root,LinkedList<TreeNode>list){
		TreeNode tmp = list.getFirst();	
		int v = tmp.data;
		if(list.size() == 0)return null;
		if(v==-1){
			list.removeFirst();
			return null;
		}
		list.removeFirst();
		root = tmp;
		root.left = deserialize(root.left,list);
		root.right = deserialize(root.right,list);
		return root;
	}
	static void serialize(TreeNode node,LinkedList<TreeNode>list){
		if(node==null){
			TreeNode tmp = new TreeNode(-1);
			System.out.print(-1+" ");
			list.add(tmp);
			return;
		}
		System.out.print(node.data+" ");
		list.add(node);
		serialize(node.left,list);
		serialize(node.right,list);
	}
}

class TreeNode{
	TreeNode left,right;
	int data;
	public TreeNode(int data){
		this.data = data;
	}
}
