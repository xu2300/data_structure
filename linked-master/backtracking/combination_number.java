package backtracking;

import java.util.Arrays;

public class combination_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10, 1, 2, 7, 6, 1, 5, -2};
		System.out.println(combinationSum2(a,8));
	}
	
    public static int combinationSum2(int[] candidates, int target) {
    	if (candidates == null) {
            return 0;
        }
    	int [] a =  {0};
          Arrays.sort(candidates);
          sum(candidates,a,0,target);
          return a[0];
      }
      
      public static void sum(int[] candidates, int[] count, int start,int target){
          if(target == 0){
             count[0]++;
              return;
          }
          else{
              for(int i =start;i<candidates.length && candidates[i]<=target;i++){
                if (i == start || candidates[i] != candidates[i - 1]) {
                 sum(candidates,count,i+1,target-candidates[i]);
              }
              }
          }
      }
}
