package amazon;

import java.util.Stack;

public class root_node_path {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        //root.right = new TreeNode(22);
       root.left.left = new TreeNode(4);
       //root.left.right = new TreeNode(12);
      // root.left.right.left = new TreeNode(10);
      // root.left.right.right = new TreeNode(14);
        System.out.println(maxsum(root));
	}
	
	
	
	public static int maxsum(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		if(root == null) return 0;
		int max = Integer.MIN_VALUE;
		s.push(root);
		while(!s.isEmpty()){
			root = s.pop();
			if(root.val > max ) max = root.val;
			if(root.right!=null){
				root.right.val = root.right.val + root.val;
				s.push(root.right);
			}
			if(root.left!=null){
				root.left.val = root.left.val + root.val;
				s.push(root.left);
			}
		}
		return max;
	}
	
	
	public static class TreeNode {
		 
	    int val;
	    TreeNode left, right;
	 
	    TreeNode(int item) {
	        val = item;
	        left = right = null;
	    }
	}
}
