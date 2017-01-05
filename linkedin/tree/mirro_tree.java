package tree;

import design.Node;

public class mirro_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node mirrorTree(Node root){
		if(root!=null){
			Node t = root.left;
			root.left = root.right;
			root.right = t;
			mirrorTree(root.right);
			mirrorTree(root.left);
		}
		return root;
	}

}
