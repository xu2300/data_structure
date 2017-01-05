package backtracking;

import java.util.*;

public class buttonCombine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String l : buttonCombine(new ArrayList<Integer>(Arrays.asList(1,2,3,4)))){
			System.out.println(l);
		}
	}
	
	public static  List<String>  buttonCombine(List<Integer> nums){
	     List<String> re = new ArrayList<String>();
	     boolean[] used = new boolean[nums.size()];
	     help(re,0, new StringBuilder(), used, nums);
	     return re;
	}
	
	public static void help( List<String> r,int level, StringBuilder sb, boolean[] used, List<Integer> nums){
	    int size = nums.size();
	    if(sb.length()!=0 && sb.charAt(sb.length()-1)!='-'){
	    	StringBuilder newsb = new StringBuilder(sb);
	    	r.add(newsb.toString());
	    }
		if(level == size) return;
	    for(int i=0; i<size; i++){
			if(!used[i]){
				used[i] = true;
				sb.append(nums.get(i));
				help(r,level+1, sb, used, nums);
				sb.deleteCharAt(sb.length()-1);
				if(level!=size-1){
					sb.append(nums.get(i)+"-");
					help(r,level+1, sb, used, nums);
					sb.delete(sb.length()-2, sb.length());
				}
				used[i] = false;
			}
		}
	}

}


/*  code：
1. 给一堆button 1 2 3 4 5 ， 可以按很多次，但是不能有重复，每次按的button可以是多个button的组合，like 1-23-4，

    1-23-4 跟 1-32-4不算重复，1-23-34算重复，
    输出所有可能的按法。
    我感觉跟subset类似，所以用了recursion求所有可能的combination，然后对每个combination求剩下的button的combination，每次求combination都存进一种可能性，如此往复，直到没有button可以选择。. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
    combination的代码写完了，解释了很久才说懂他，后面处理的函数没有写完，说了思路写了些伪代码跟注释。. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
. */

