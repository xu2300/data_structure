package design;

import java.util.*;


/*
public class Solution {
   private List<Interval> intervals = new ArrayList<>();
   /**
    * Adds an interval [from, to] into internal structure.
    */
/*
   void addInterval(int from, int to) {
       Interval interval = new Interval(from, to);
       intervals.add(interval);
   }

/*
   /**
    * Returns a total length covered by intervals.
    * If several intervals intersect, intersection should be counted only once.
    * Example:
    *
    * addInterval(3, 6)
    * addInterval(8, 9)
    * addInterval(1, 5)
    *
    * getTotalCoveredLength() -> 6
    * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
    * [1,6] and [8,9] don't intersect so total covered length 
    * is a sum for both intervals, that is 6.
    *
    *                   _________
    *                                               ___
    *     ____________
    *
    * 0  1    2    3    4    5   6   7    8    9    10
    *
    */
   /*
   int getTotalCoveredLength() {
       if (intervals.isEmpty()) {
           return 0;
       }
        
       Collections.sort(intervals, new IntervalComparator());
        
       int len = 0;
        
       Interval prev = intervals.get(0);
        
       for (int i = 1; i < intervals.size(); i++) {
           Interval curr = intervals.get(i);
            
           if (overlaps(prev, curr)) {
               prev.start = prev.start;
               prev.end = Math.max(prev.end, curr.end);
           } else {
               len += prev.end - prev.start;
               prev = curr;
           }
       }
        
       len += prev.end - prev.start; // Be very careful to check this case. 
        
       return len;
   }
    
   public static void main(String[] args) {
       Solution intervals = new Solution();
       intervals.addInterval(3, 6);
       intervals.addInterval(8, 9);
       intervals.addInterval(1, 5);
        
       int len = intervals.getTotalCoveredLength();
        
       System.out.println(len);
   }
    
   private class IntervalComparator implements Comparator<Interval> {
       @Override
       public int compare(Interval a, Interval b) {
           return a.start - b.start;
       }
   }
    
   private boolean overlaps(Interval prev, Interval curr) {
       return prev.end > curr.start;
   }
}

class Interval {
   int start;
   int end;
    
   public Interval(int start, int end) {
       this.start = start;
       this.end = end;
   }
}
*/

   
public class Add_Intervals {
    private List<Interval> re = new ArrayList<>();
    private int maxLen = 0;
    void addInterval(int from, int to) {
    		List<Interval> r = new ArrayList<Interval>();
    		maxLen = 0;
        int len = re.size();
        int i =0;
        while(i<len && from>re.get(i).end){
        		r.add(re.get(i));
        		maxLen += re.get(i).end - re.get(i).start;
        		i++;
        }
        while(i<len && to>=re.get(i).start){
        		from = Math.min(from, re.get(i).start);
        		to = Math.max(to, re.get(i).end);
        		i++;
        }
        maxLen +=to-from;
        Interval interval = new Interval(from, to);
        r.add(interval);
        while(i<len){
        		r.add(re.get(i));
        		maxLen +=re.get(i).end - re.get(i).start;
        		i++;
        }
        re = r;
    }
 
    int getTotalCoveredLength() {
        return maxLen;
    }
     
    public static void main(String[] args) {
        Add_Intervals intervals = new Add_Intervals();
        intervals.addInterval(3, 6);
        intervals.addInterval(8, 9);
        intervals.addInterval(1, 4);
        intervals.addInterval(10, 12);
        intervals.addInterval(11, 13);
        int len = intervals.getTotalCoveredLength();
        System.out.println(len);
    }
      
    class Interval {
        int start;
        int end;
         
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}


