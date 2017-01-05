package design;

import java.util.List;



public class StackToFindMiddle {
		
	public static class DLLNode{
		int val;	
		DLLNode right;
		DLLNode left;
		public DLLNode(int element) {
			this.val = element;
		}
	}
	
    DLLNode head;
    DLLNode middle;
   int size=0;
   
        public void push(int val) {
                size++;
                if(head==null) {
                        head=new DLLNode(val);
                        middle=head;
                }else {
                        DLLNode node =new DLLNode(val);
                        node.right=head;
                        head.left=node;
                        head=node;
                        if(size%2==1) {
                                middle=middle.left;
                        }
                }
        }

        public int pop() {
                if(head==null) {
                        return -1;
                }
                size--;
                int ret;
                ret=head.val;
                if(size==0) {
                        head=null;
                        middle=null;
                }else {
                        head=head.right;
                        head.left=null;
                        if(size%2==0) {
                                middle=middle.right;
                        }
                }
                return ret;
        }

        public int findMiddle() {
            if(middle == null) return -1;    
        	return middle.val;
        }


        public void deleteMiddle() {
                size--;
                if(middle.left!=null) {
                        middle.left.right=middle.right;
                }
                if(middle.right!=null) {
                        middle.right.left=middle.left;
                }
                if(size%2==1) {
                        middle=middle.right;
                }else {
                        middle=middle.left;
                }
        }
}