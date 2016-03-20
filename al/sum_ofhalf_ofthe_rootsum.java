

public class sum_ofhalf_ofthe_rootsum {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(10);
		node.right =node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.right = node5;
		int target = count(node)/2;
		System.out.println(target);
		System.out.println(closet (node, target,Integer.MAX_VALUE));
	}
	
	public static int closet(TreeNode root, int target, int min){
		int curmin = Math.abs(min - target)<Math.abs(root.val - target)?min:root.val;
		if(root.left !=null) {
			int left = closet(root.left, target, curmin);
			curmin = Math.abs(curmin - target)<Math.abs(left - target)?curmin:left;
		}
		if(root.right !=null) {
			int right = closet(root.right, target, curmin);
			curmin = Math.abs(curmin - target)<Math.abs(right - target)?curmin:right;
		}
		return curmin;
	}
	
	public static int count(TreeNode root){
		if(root == null) return 0;
		int left = count(root.left);
		int right =count(root.right);
		root.val += (left +right);
		return root.val;
	}
	
	public static class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
	}
}
