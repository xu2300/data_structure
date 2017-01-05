package design;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MAX_STACK<T> {

    PriorityQueue<Dlink> maxHeap;
    Dlink head;

	public class Dlink{
        Dlink pre;
        Dlink next;
        T val;
        public Dlink (){};
        public Dlink ( T n){
            val = n;
        }
    }
    
    public void add(Dlink node){
        if(node == null) return;
    	node.next = head.next;
        if(head.next!=null)
        	head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    
    public void remove(Dlink node){
        if(node == null) return;
    	node.pre.next = node.next;
        if(node.next!=null)
    	node.next.pre = node.pre;
    }
    
    public Dlink poll(){
        Dlink node = head.next;
        remove(node);
        return node;
    }


    public MAX_STACK() {
        head = new Dlink();
    	maxHeap = new PriorityQueue<Dlink>(10, new Comparator<Dlink>(){
    		public int compare(Dlink a, Dlink b){
    			return (int)b.val-(int)a.val;
    		}
    	});  // reverse order
    }

    public void push(T n) {
        Dlink m = new Dlink(n);
    	add(m);
        maxHeap.add(m);
    }

    public T pop() {
        Dlink num = poll();
        maxHeap.remove(num);
        if(num == null) return null;
        return num.val;
    }

    public T top() {
        return head.next.val;
    }

    public T peekMax() {
        return maxHeap.peek().val;
    }

    public T popMax() {
        Dlink num = maxHeap.poll();
        remove(num);
        return num.val;
    }

    public static void main(String[] args) {
    	MAX_STACK stack = new MAX_STACK();
        int[] arr = {3, 1, 2, 4, 6, 5};
        for (Integer n: arr) {
            stack.push(n);
        }
        System.out.println(stack.popMax());  // 6
        System.out.println(stack.popMax());  // 5
        System.out.println(stack.popMax());  // 4
        System.out.println(stack.pop());     // 2
        System.out.println(stack.popMax());  // 3
    }
	
}





import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxStack<T> {

    LinkedList<T> stack;
    PriorityQueue<T> maxHeap;

    public MaxStack() {
        stack = new LinkedList<T>();
        maxHeap = new PriorityQueue<T>(10, Collections.reverseOrder());  // reverse order
    }

    public void push(T n) {
        stack.addLast(n);
        maxHeap.offer(n);
    }

    public T pop() {
        T num = stack.removeLast();
        maxHeap.remove(num);
        return num;
    }

    public T top() {
        return stack.peekLast();
    }

    public T peekMax() {
        return maxHeap.peek();
    }

    public T popMax() {
        T num = maxHeap.poll();
        stack.remove(num);
        return num;
    }

    public static void main(String[] args) {
        MaxStack<Integer> stack = new MaxStack<Integer>();
        int[] arr = {3, 1, 2, 4, 6, 5};
        for (Integer n: arr) {
            stack.push(n);
        }
        System.out.println(stack.popMax());  // 6
        System.out.println(stack.popMax());  // 5
        System.out.println(stack.popMax());  // 4
        System.out.println(stack.pop());     // 2
        System.out.println(stack.popMax());  // 3
    }
}
