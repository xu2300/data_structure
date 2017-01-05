package design;

import tree.TreeNode;

public class serialization_and_deserialization {

	//Method 1: Pre order
	class Solution {
	  public String serialize(TreeNode root) {
	    if (root == null) {
	      return "";
	    }
	    return preOrder(new StringBuilder(), root);
	  }

	  private String preOrder(StringBuilder sb, TreeNode root) {
	    if (root == null) {
	        sb.append("# ");
	      return "";
	    }
	    sb.append(root.val);
	    sb.append(" ");
	    preOrder(sb, root.left);
	    preOrder(sb, root.right);
	    return sb.toString();
	  }

	  public TreeNode deserialize(String data) {
	    if (data == null || data.length() == 0) {
	      return null;
	    }
	    int end = data.indexOf(' ');
	    String valueStr = data.substring(0, end);
	    TreeNode root = null;
	    if (!valueStr.equals("#")) {
	      root = new TreeNode(Integer.parseInt(valueStr));
	    }
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;
	    while (cur != null || !stack.isEmpty()) {
	      while (cur != null) {
	        int start = end + 1;
	        end = data.indexOf(' ', start);
	        valueStr = data.substring(start, end);
	        TreeNode child = null;
	        if (!valueStr.equals("#")) {
	          child = new TreeNode(Integer.parseInt(valueStr));
	        }
	        cur.left = child;
	        stack.push(cur);
	        cur = cur.left;
	      }
	      if (!stack.isEmpty()) {
	        cur = stack.pop();
	        int start = end + 1;
	        end = data.indexOf(' ', start);
	        valueStr = data.substring(start, end);
	        TreeNode child = null;
	        if (!valueStr.equals("#")) {
	          child = new TreeNode(Integer.parseInt(valueStr));
	        }
	        cur.right = child;
	        cur = cur.right;
	      }
	    }
	    return root;
	  }
	}
	
	
	
	
	
	
	//Method 2: Level order
	class Solution {
	  public String serialize(TreeNode root) {
	    if (root == null) {
	      return "";
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    queue.add(null);
	    StringBuilder sb = new StringBuilder();
	    sb.append(root.val);
	    while (!queue.isEmpty()) {
	      TreeNode cur = queue.remove();
	      if (cur == null) {
	        if (queue.isEmpty()) {
	          break;
	        }
	        queue.add(null);
	      } else{
	        if (cur.left != null) {
	          queue.add(cur.left);
	          sb.append(",");
	          sb.append(cur.left.val);
	        } else {
	          sb.append(",#");
	        }
	        if (cur.right != null) {
	          queue.add(cur.right);
	          sb.append(",");
	          sb.append(cur.right.val);
	        } else {
	          sb.append(",#");
	        }
	      }
	    }
	    return sb.toString();
	  }

	  public TreeNode deserialize(String data) {
	    if (data == null || data.length() == 0) {
	      return null;
	    }
	    String[] values = data.split(",");
	    Queue<TreeNode> queue = new LinkedList<>();
	    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
	    queue.add(root);
	    int childIndex = 1;
	    while (!queue.isEmpty() && childIndex < data.length()) {
	      TreeNode cur = queue.remove();
	      if (childIndex < data.length() && !values[childIndex].equals("#")) {
	        TreeNode leftChild = new TreeNode(Integer.parseInt(values[childIndex]));
	        cur.left = leftChild;
	        queue.add(leftChild);
	      }
	      ++childIndex;
	      if (childIndex < data.length() && !values[childIndex].equals("#")) {
	        TreeNode rightChild = new TreeNode(Integer.parseInt(values[childIndex]));
	        cur.right = rightChild;
	        queue.add(rightChild);
	      }
	      ++childIndex;
	    }
	    return root;
	  }
	}
	
	
	
	
	//Method 3: Reconstruct from pre-order and in-order
	class Solution {
	  public String serialize(TreeNode root) {
	    if (root == null) {
	      return "";
	    }
	    return preOrder(new StringBuilder(), root) 
	        + "#" + inOrder(new StringBuilder(), root);
	  }

	  private String preOrder(StringBuilder sb, TreeNode root) {
	    if (root == null) {
	      return "";
	    }
	    sb.append(root.val);
	    sb.append(" ");
	    preOrder(sb, root.left);
	    preOrder(sb, root.right);
	    return sb.toString();
	  }

	  private String inOrder(StringBuilder sb, TreeNode root) {
	    if (root == null) {
	      return "";
	    }
	    inOrder(sb, root.left);
	    sb.append(root.val);
	    sb.append(" ");
	    inOrder(sb, root.right);
	    return sb.toString();
	  }

	  public TreeNode deserialize(String data) {
	      if (data == null || data.length() == 0) {
	          return null;
	      }
	    String[] twoParts = data.split("#");
	    int[] preOrder = convertToIntArray(twoParts[0]);
	    int[] inOrder = convertToIntArray(twoParts[1]);
	    assert preOrder.length == inOrder.length;
	    // preprocess
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < inOrder.length; ++i) {
	      map.put(inOrder[i], i);
	    }
	    // reconstruct tree
	    return deseralizeHelper(preOrder, 0, inOrder, 0, inOrder.length - 1, map);
	  }

	  private TreeNode deseralizeHelper(int[] preOrder, int pre_index, 
	      int[] inOrder, int in_start, int in_end, Map<Integer, Integer> map) {  
	    if (in_end < in_start) { 
	      return null;
	    }
	    int rootValue = preOrder[pre_index];
	    TreeNode root = new TreeNode(rootValue); 
	    int in_pos = map.get(rootValue); 
	    int left_len = in_pos - in_start; 
	    root.left = deseralizeHelper(preOrder, pre_index + 1, inOrder, in_start, in_pos - 1, map); 
	    root.right = deseralizeHelper(preOrder, pre_index + 1 + left_len, inOrder, in_pos + 1, in_end, map); 
	    return root;
	  }

	  private int[] convertToIntArray(String traversalStr) {
	    String[] fields = traversalStr.split(" ");
	    int[] traversalArr = new int[fields.length];
	    for (int i = 0; i < fields.length; ++i) {
	      traversalArr[i] = Integer.parseInt(fields[i]);
	    }
	    return traversalArr;
	  }
	}
}
