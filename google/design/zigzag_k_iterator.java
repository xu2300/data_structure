package design;

/**
 * Created by junweixu on 1/31/17.
 */
import java.util.*;

public  class zigzag_k_iterator implements Iterator<Integer> {
    Queue<Iterator<Integer>> q;
    public zigzag_k_iterator(Iterator<Iterator<Integer>> iter) {
        q = new LinkedList<Iterator<Integer>>();
        while(iter.hasNext()) q.add(iter.next());
    }

    @Override
    public synchronized boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public synchronized Integer next() {
        if(q.isEmpty()) throw new NullPointerException("The queue is empty");
        Iterator<Integer> cur = q.poll();
        int result = cur.next();
        if(cur.hasNext())q.add(cur);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1,2,3));
        List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(4,5,6,7));
        List<Integer> l3 = new LinkedList<Integer>(Arrays.asList(8,9));
        List<Iterator<Integer>> iter = new LinkedList<>();
        iter.add(l1.iterator());
        iter.add(l2.iterator());
        iter.add(l3.iterator());
        zigzag_k_iterator zigzag = new zigzag_k_iterator(iter.iterator());
        while(zigzag.hasNext()) System.out.print(zigzag.next());
        System.out.print(zigzag.next());
    }
}
