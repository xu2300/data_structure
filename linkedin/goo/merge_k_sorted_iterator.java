package goo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import goo.k_nearest_point.Point;

import java.util.Comparator;

public class merge_k_sorted_iterator {

	public static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
        List<Integer> result = new ArrayList<>();
        if (iterators == null || iterators.size() == 0) {
            return result;
        }
         
        PriorityQueue<MyIterator> pq = new PriorityQueue<>(iterators.size());
         
        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                pq.add(new MyIterator(iterator.next(), iterator));
            }
        }
         
        while (!pq.isEmpty()) {
            MyIterator curr = pq.poll();
            result.add(curr.val);
            if (curr.hasNext()) {
                pq.add(curr);
            }
        }
         
        return result;
    }
     
    private static class MyIterator implements Comparable<MyIterator> {
        private Integer val;
        private Iterator<Integer> iterator;
         
        public MyIterator(Integer val, Iterator<Integer> iterator) {
            this.val = val;
            this.iterator = iterator;
        }
         
        public boolean hasNext() {
            if (iterator.hasNext()) {
                val = iterator.next();
                return true;
            } 
             
            return false;
        }
         
        public int compareTo(MyIterator that) {
            return this.val - that.val;
        } 
    }
  
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
         
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
        
        List<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(7);
         
        List<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(a.iterator());
        iterators.add(b.iterator());
        iterators.add(c.iterator());
         
        Iterable<Integer> result = mergeKSortedIterators(iterators);
         
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }

}
