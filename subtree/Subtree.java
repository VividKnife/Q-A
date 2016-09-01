//Question: Given two binary trees, check if the first tree is subtree of the second one. 
//A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T. 
//The subtree corresponding to the root node is the entire tree; the subtree corresponding to 
//any other node is called a proper subtree.


public class Subtree {


	
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
            TreeNode root=new TreeNode(10);  
            root.left=new TreeNode(4);  
            root.right=new TreeNode(6);  
            root.left.right=new TreeNode(30);  
              
            TreeNode root2=new TreeNode(26);  
            root2.left=new TreeNode(10);  
            root2.left.left=new TreeNode(4);  
            root2.left.right=new TreeNode(6);  
            root2.right=new TreeNode(6);  
            root2.left.left.right=new TreeNode(30);  
            root2.right=new TreeNode(3);  
            root2.right.right=new TreeNode(3);  
              
            System.out.println(isSubTree(root,root2));  
            //System.out.println(isIdentical(root,root2));  
    }
	
	int calledTimes = 0;
 
	  

	
	public static boolean isSubTree(TreeNode root1,TreeNode root2)
	{
		if(root1==null){ 
			
			return true;}
		if(root2==null) return false;
		if(isIdentical(root1,root2)) return true;
		else{
			boolean sub =isIdentical(root1,root2.left)||isIdentical(root1,root2.right);
			return sub;
		}
	}
	public static boolean isIdentical(TreeNode root1, TreeNode root2)
	{
		if(root1==null&&root2==null) return true;
		if(root1==null||root2==null) return false;
		if(root1.val==root2.val)
		{
			return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
		}
		return false;
	}

}
