package backtracking;

import java.util.ArrayList;
import java.util.List;

public class plus_factor {
	public static void main(String[] args) {
		for(List<Integer> l : getFactors(2)){
			for(int i: l){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        dfs(re,n,new ArrayList<Integer>(), n,1);
        return re;
    }
    
    public static void dfs(List<List<Integer>> re, int sum, List<Integer> l, int n, int s){
    	if(sum == 0){
    		re.add(new ArrayList<Integer>(l));
    		return;
    	}
    	for(int i = s; i<=sum; i++){
    		if(i==n){
    			return;
    		}
    		l.add(i);
    		dfs(re,sum-i,l, n,i);
    		l.remove(l.size()-1);
    	}
    }
}
