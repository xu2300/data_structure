import java.util.ArrayList;
import java.util.List;

public class deepest_common_ancestor {
	
	public static class TreeNode{
		int val;
		List<TreeNode> child;
		public TreeNode(int val){
			this.val = val;
			child = new ArrayList<TreeNode>();
		}
	}
	
	public static class Result{
		TreeNode node;
		int maxDepth;
		public Result(TreeNode node, int maxDepth){
			this.node = node;
			this.maxDepth = maxDepth;
		}
	}
	
	public static TreeNode find(TreeNode root){
		if(root == null || root.child.isEmpty()) return root;
		return helper(root).node;
	}
	
	public static Result helper(TreeNode root){
		Result rr = new Result(root, 1);
		if(root.child.isEmpty()) return rr;
		int size = root.child.size();
		int maxDepth = Integer.MIN_VALUE;
		Result r = new Result(root,maxDepth);
		for(int i =0; i<size; i++){
			Result tmp = helper(root.child.get(i));
			if(tmp.maxDepth > maxDepth){
				maxDepth = tmp.maxDepth;
				r.node = tmp.node;
				r.maxDepth = tmp.maxDepth + 1;
			}
			else if(tmp.maxDepth == maxDepth) r.node = root;
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);  
        n1.child.add(n2);
        n1.child.add(n3);
        n1.child.add(n4);
        n2.child.add(n5);
        n2.child.add(n6);
        n4.child.add(n7);
        n5.child.add(n8);
        n5.child.add(n9);
        n6.child.add(n10);
        TreeNode res = find(n1);
        System.out.println(res.val);
	}

}
