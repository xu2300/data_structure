package tree;

public class single_valid_tree {
/*
 * 
 * Given a list of nodes, each with a left child and a right child (they can be null),
 *  determine if all nodes belong in a single valid binary tree. The root is not given.


1
of 1 vote
The solution can be designed with the following idea which runs in multiple passes:

Pass1: Read every node and for each node remember what other nodes are pointing to 
it using additional data structures

Pass2: Read every node to find the following:
a. Nodes who are pointed to by 0 other nodes ==> These are potential roots
b. Nodes who are pointed to by 1 nodes
c. Nodes who are pointed to by > 1 nodes

We have a valid binary tree iff:

1. The number of nodes whom nobody points to is 1 and that is the root
2. Every node is pointed to by at most one node
3. Starting with the root, and doing a DFS or a BFS covers all the nodes in the list
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isValid(List<TreeNode> nodes){
	  	HashSet<TreeNode> children = new HashSet<> ();
	  	// child node only has one parent node
	  	for (TreeNode node : nodes) {
	  		if (node.left != null) {
	  			if (!children.add(node.left)) return false ;
	  		}
	  		if (node.right != null) {
	  			if (!children.add(node.right)) return false ;
	  		}
	  	}
	  	
	  	TreeNode start = null ;
	  	int count = 0 ;
	  	for (TreeNode node : nodes) {
	  		if (!children.contains(node)) {	  			
	  			start = node ;
	  			count ++ ;
	  		}
	  	}	  	
	  	// only has one root node
	  	if (count > 1) return false ;
	  		
	  	// running bfs to make sure all nodes can be constructed as a binary tree 
	  	Queue<TreeNode> q = new LinkedList<> ();
	  	q.add(start) ;	  	
	  	while (!q.isEmpty()) {
	  	   int size = q.size() ;
	  	   for (int i = 0 ; i < size ; ++i) {
	  		   TreeNode cur = q.poll() ;
	  		   if (cur.left != null) {
	  			   q.add(cur.left) ;
	  			   children.remove(cur.left) ;
	  		   }
	  		   if (cur.right != null) {
	  			 q.add(cur.right) ;
	  			 children.remove(cur.right) ;
	  		   }
	  	   }
	  	}	  		  	
	  	return children.size() == 0 ;
	}
}
