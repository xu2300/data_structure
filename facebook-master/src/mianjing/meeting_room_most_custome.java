import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class meeting_room_most_custome {
	class Interval {
	    int start, end;
	    public Interval(int start, int end) {
	        this.start = start;
	        this.end = end;
	    }
	}
	 
	public static void main(String[] args) {

	}
	
	class Solution {
	    /**
	     * @param intervals: An interval array
	     * @return: Count of airplanes are in the sky.
	     */
	    public int countOfAirplanes(List<Interval> airplanes) { 
	        // write your code here
	        List<Integer> s = new ArrayList<Integer>();
	        List<Integer> l = new ArrayList<Integer>();
	        for(Interval inter: airplanes ){
	            s.add(inter.start);
	            l.add(inter.end);
	        }
	        Collections.sort(s);
	        Collections.sort(l);
	        int count = 0;
	        int i = 0;
	        int j = 0;
	        int max = 0;
	        
 	        while(i<s.size()){
	            if(s.get(i)<l.get(j)){
	                count ++;
	                i++;
	            }
	            else if(s.get(i)>=l.get(j)){
	                count --;
	                j++;
	            }
	            max = Math.max(max,count);
	        }
	        return max;
	    }
	}
}
