package tree;
/*
 * 
 * 
 * Given a tree string expression in balanced parenthesis format:. 鍥磋鎴戜滑@1point 3 acres
[A[B[C][D]][E][F]]
Construct a tree and return the root of the tree.
                A
            /   |  \
          B    E   F
         / \
       C   D
 */
import java.util.LinkedList;
import java.util.Stack;

public class string_parse_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(A(B(C)(D))(E)(F))";
		TreeNode root = createTree(s);
		System.out.print(root.value);
		for(TreeNode m: root.children)
		System.out.print(m.value);
	}

	public static TreeNode createTree(String s) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode root = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                root = st.pop();
            } else if (c >= 'A' && c <= 'Z') {
                TreeNode newNode = new TreeNode(c);
                if (!st.isEmpty()) {
                    st.peek().children.add(newNode);
                }
                st.push(newNode);
            }
        }
        return root;
    }


	public static class TreeNode {
        public char value;
        public LinkedList<TreeNode> children;

        public TreeNode(char value) {
            this.value = value;
            children = new LinkedList<TreeNode>();
        }
    }
}
