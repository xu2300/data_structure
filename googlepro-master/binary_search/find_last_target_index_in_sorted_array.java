package binary_search;

import java.util.Random;

public class find_last_target_index_in_sorted_array {
	public static void main(String[] args) {
		int [] re = { 1,2,2,2,3, 5};
		System.out.print(find(re,2));
	}
	
	public static int find(int [] re, int target){
		int len = re.length;
		if(len == 0) return -1;
		int l = 0, h = len-1;
		while(l<=h){
			int m = l+(h-l)/2;
			if(re[m] == target){
				if(m == len-1 || re[m+1]!=target) return m;
				else l = m+1;
			}
			else if(re[m]< target){
				l = m+1;
			}
			else h = m-1;
		}
		return -1;
	}
}
