package tree;

import java.util.ArrayList;
import java.util.List;

public class find_depth {
/*
	Consider this string representation for binary trees. 
	Each node is of the form (lr), where l represents the left child and r represents the right child. 
	If l is the character 0, then there is no left child. Similarly, 
	if r is the character 0, then there is no right child. Otherwise, 
	the child can be a node of the form (lr), and the representation continues recursively.
	For example: (00) is a tree that consists of one node.
	((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. 
	And ((00)(00)) is a three-node tree, with a root, a left and a right child.
	Write a function that takes as input such a string,
	and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed.
	For instance:
	For instance:
  find_depth('(00)') -> 0 
  find_depth('((00)0)') -> 1 
  find_depth('((00)(00))') -> 1 
  find_depth('((00)(0(00)))') -> 2 
  find_depth('((00)(0(0(00))))') -> 3 
  find_depth('x') -> -1 
  find_depth('0') -> -1 
  find_depth('()') -> -1 
  find_depth('(0)') -> -1 
  find_depth('(00)x') -> -1 
  find_depth('(0p)') -> -1
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getLength(String str) {
	    int depth = -1;
	    while (!str.equals("0")) {
	        String newStr = str.replace("(00)", "0");
	        if (newStr.equals(str)) {
	            return -1;
	        }
	        str = newStr;
	        ++depth;
	    }
	    return depth;
	}
	
	public static int getLength2(String str) {
	    int depth = -1;
	    char[] pattern = {'(', '0', '0', ')'};
	    char[] strArr = str.toCharArray();
	    while (strArr.length != 1) {
	        List<Integer> points = new ArrayList<Integer>();
	        int start = 0;
	        while (start + 3 < strArr.length) { // find all pattern
	            int i = start;
	            while (i < start + 4) {
	                if (strArr[i] != pattern[i - start]) {
	                    break;
	                }
	                ++i;
	            }
	            if (i - start == 4) {
	                points.add(start);
	                start += 4;
	            } else {
	                ++start;
	            }
	        }
	        if (points.size() == 0) {  // cannot change anymore
	            break;
	        }
	        // substitute all pattern
	        char[] newArr = new char[strArr.length - points.size()*3];
	        int j = 0;
	        int k = 0;
	        while (j < strArr.length) {
	            if (k == points.size()) {
	                newArr[j - k * 3] = strArr[j++];
	            } else if (j == points.get(k)) {
	                newArr[j - k * 3] = '0';
	                ++k;
	                j += 4;
	            } else {
	                newArr[j - k * 3] = strArr[j++];
	            }
	        }
	        strArr = newArr;
	        ++depth;
	    }
	    if (depth == -1 || strArr.length != 1 || strArr[0] != '0') {
	        return -1;
	    }
	    return depth;
	}

}
