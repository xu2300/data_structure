package wish;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by junweixu on 8/20/17.
 */
public class ithPowerNumber {
    public static void main(String[] args) {
        for(int i=0; i<10; i++)
        System.out.println(number(i));
    }

    public static long number(int n){
        PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return Long.compare(o1.value, o2.value);
            }
        });
        for(long i=2; i<2+n+1; i++){
            pq.add(new node(i, i*i));
        }
        for(int i=0; i<n; i++){
            node curNode = pq.poll();
            long curValue = curNode.value;
            curNode.value = curNode.value * curNode.base;
            pq.add(curNode);
            while(pq.peek().value == curValue){
                node sameValueNode = pq.poll();
                sameValueNode.value = sameValueNode.value * sameValueNode.base;
                pq.add(sameValueNode);
            }
        }
        return pq.peek().value;
    }

    public static class node{
        long base;
        long value;
        public node(long base, long value){
            this.base = base;
            this.value = value;
        }
    }
}
