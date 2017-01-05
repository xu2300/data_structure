package backtracking;

import java.util.HashSet;

public class combination_sum_at_least_two_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {1,1,3,4};
		for(int i : sum(a)){
			System.out.println(i);
		}
	}
	
	public static int [] sum(int [] a){
		HashSet<Integer> s = new HashSet<Integer>();
		help(s,a,0,0,0);
		int[]re = new int[s.size()];
		int index =0;
		for(int m: s){
			re[index++] = m;
		}
		return re;
	}
	
	public static void help(HashSet<Integer> s, int [] a, int start, int sum, int level){
		if(level>=2)
		s.add(sum);
		int len = a.length;
		for(int i= start; i<len; i++){
			help(s,a,i+1,sum+a[i],level+1);
		}
	}
	
	
	/* You have several coins with values in a bag. 
	 * You can grab any amount of coins from the bag once. 
	 * How many different values of the sum of coins can you get?. 1point3acres.com/bbs
	 Input is the list of values of the coins and output should be possibilities of sums of coin values
	 */
	/*public static int [] sum(int [] a){
		HashSet<Integer> s = new HashSet<Integer>();
		help(s,a,0,0,0);
		int[]re = new int[s.size()];
		int index =0;
		for(int m: s){
			re[index++] = m;
		}
		return re;
	}
	
	public static void help(HashSet<Integer> s, int [] a, int start, int sum, int level){
		if(level>=1)
		s.add(sum);
		int len = a.length;
		for(int i= start; i<len; i++){
			help(s,a,i+1,sum+a[i],level+1);
		}
	}*/
}
