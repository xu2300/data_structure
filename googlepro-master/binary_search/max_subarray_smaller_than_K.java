package binary_search;

import java.util.TreeSet;

public class max_subarray_smaller_than_K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int maxSumSubArray(int[] a , int k){

	    int max = Integer.MIN_VALUE;
	    int sumj = 0;
	    TreeSet<Integer> s = new TreeSet();
	    s.add(0);

	    for(int i=0;i<a.length;i++){
	        int t = sumj + a[i];
	        sumj = t;
	        Integer gap = s.ceiling(sumj - k);
	        if(gap != null) max = Math.max(max, sumj - gap);
	        s.add(t);
	    }

	    return max;
	}
}
