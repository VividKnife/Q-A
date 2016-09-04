
import java.util.ArrayList;
import java.util.Collections;


public class BTreeToBST {
	


	public static ArrayList<Integer> TreeData = new ArrayList<Integer>();
	public static ArrayList<Integer> sortedTreeData = new ArrayList<Integer>();
	public static TreeNode TN = new TreeNode(10);
	//public TreeNode TN;
	static int i = 0;
	public static void printTree(TreeNode TN)
	{
		if(TN == null)
			return;
		printTree(TN.left);
		System.out.println(TN.val+"p ");
	    TreeData.add(TN.val);
	    
		printTree(TN.right);
	}
	

	
	public static void BTreeToBSTree(TreeNode TN)
	{
		
		if(TN == null)
			return;
		BTreeToBSTree(TN.left);
		TN.val = sortedTreeData.get(i++);
		BTreeToBSTree(TN.right);
	}
	
	public static void main(String args[])
	{
		
		TN.left = new TreeNode(30);
		TN.right = new TreeNode(15);
		TN.left.left = new TreeNode(20);
		TN.right.right = new TreeNode(5);

		printTree(TN);
		Collections.sort(TreeData);
		sortedTreeData = TreeData;	
		BTreeToBSTree(TN);
		System.out.println("Start---------------");
		printTree(TN);
	}
}
