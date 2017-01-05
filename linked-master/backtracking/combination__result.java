package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination__result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]candidates = {10, 1, 2, 7, 6, 1, 5, -2};
		int target = 8;
		List<List<Integer>> re = combinationSum2(candidates, target);
		for(List<Integer> l: re){
			for(int i : l){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        help(candidates,target, r, new ArrayList<Integer>()  , 0);
        return r;
    }
    
    public static void help(int[] candidates, int target,List<List<Integer>> r,  List<Integer> l, int level){
        if(target == 0){
            r.add(new ArrayList<Integer>(l));
            return ;
        }
        for(int i = level; i<candidates.length &&  candidates[i] <= target; i++){
            if(i==level || candidates[i] != candidates[i-1]){
                l.add(candidates[i]);
                help(candidates, target-candidates[i], r, l , i+1);
                l.remove(l.size()-1);
            }
        }
    }

}
