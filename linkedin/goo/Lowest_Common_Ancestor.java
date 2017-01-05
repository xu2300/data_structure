package goo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Lowest_Common_Ancestor{
	
class Node {

	final Node parent; 
	final Node left; 
	final Node right; 
	final char data;


	public Node(Node parent, Node left, Node right, char data) { 
	    this.parent = parent; 
	    this.left = left; 
	    this.right = right; 
	    this.data = data;
	}

	boolean isRoot() { 
	    return parent == null; 
	}
}

public static Node commonAncestor(Node node1, Node node2) {
    Set<Node> path = new HashSet<Node>();
    while (!node1.isRoot()) {
        path.add(node1);
        node1 = node1.parent;
    }
    path.add(node1);
    
    while (!node2.isRoot()) {
        if (path.contains(node2)) {
            return node2;
        }
        node2 = node2.parent;
    }
    if (path.contains(node2)) {
        return node2;
    }
    return null;
}

public static Node commonAncestor2(Node node1, Node node2) {
    int height1 = 0;
    Node tmpNode1 = node1;
    while (!tmpNode1.isRoot()) {
        ++height1;
        tmpNode1 = tmpNode1.parent;
    }
    int height2 = 0;
    Node tmpNode2 = node2;
    while (!tmpNode2.isRoot()) {
        ++height2;
        tmpNode2 = tmpNode2.parent;
    }
    int diff = height1 - height2;
    if (diff > 0) {
        while (diff != 0) {
            node1 = node1.parent;
            --diff;
        }
    } else {
        while (diff != 0) {
            node2 = node2.parent;
            ++diff;
        }
    }
    // special case, node1 is node2's parent, or node2 is node1's parent
    if (node1 == node2) {  
        return node1.parent;
    }
    while (node1 != node2) {
        node1 = node1.parent;
        node2 = node2.parent;
    }
    return node1;
}

}
