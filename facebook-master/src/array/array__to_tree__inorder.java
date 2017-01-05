
public class array__to_tree__inorder {
	Node generateTree(int[] a, int left ,int right) {
        if (left > right)
            return null;
        int min = a[left], index = left;

        for (int i = left + 1; i <= right; i++)
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
         Node root = new Node(a[min]);
         root.left = generateTree(a, left, index - 1);
         root.right = generateTree(a, index + 1, right);
         return root;
      }

      Node addNode(Node root, int val) {
        Node inserted = new Node(val);
        if (val <= root.data) {
            inserted.left = root;
            return inserted;
        }

        Node curr = root.right, prev = root;

        while (curr != null) {
            if (val <= curr.data) {
                inserted.left = curr;
                prev.right = inserted;
                return root;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        prev.right = inserted;. 1point 3acres 璁哄潧
        return root;
      }
}
