package tree;

import java.util.LinkedList;
import java.util.Queue;

public class n_node_tree {

    public static TreeNode compact(TreeNode root, int n) {
        if (root == null || n == 0) return root;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root);
        q2.offer(root);
        int currLevel = 1, nextLevel = 0;
        while (!q1.isEmpty()) {
            TreeNode front = q1.poll();
            for (TreeNode child : front.children) {
                q1.offer(child);
                q2.offer(child);
                nextLevel++;
            }
            if (--currLevel == 0) {
                currLevel = nextLevel;
                nextLevel = 0;
            }
        }
        TreeNode newRoot = q2.poll();
        fillChildren(newRoot, q2, n);
        return newRoot;
    }
    
    private static void fillChildren(TreeNode root, Queue<TreeNode> queue, int n) {
        if (root == null || queue.isEmpty()) return;
        int count = 0;
        root.children = new ArrayList<TreeNode>();
        while (!queue.isEmpty() && count < n) {
            root.children.add(queue.poll());
            count++;
        }
        for (TreeNode child : root.children) {
            fillChildren(child, queue, n);
        }
    }
}

class TreeNode {
    int value;
    List<TreeNode> children;
    public TreeNode(int vlaue) {
        this.value = value;
        children = new ArrayList<TreeNode>();
    }
}
}
