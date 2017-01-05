package backtracking;

import java.util.*;

public class Longest_Palindrome_all_the_result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//可以delete，重新排序
		for(String s: one_longest_palidrome("data")){
			System.out.println(s);
		}
	}
	
	public static List<String> one_longest_palidrome(String s){
		List<String> r= new ArrayList<String>();
		if(s==null || s.length()==0) return r;
        HashMap<Character,Integer> hs = new HashMap<Character,Integer>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(!hs.containsKey(s.charAt(i))){
            	hs.put(s.charAt(i), 1);
            }else{
            	int num = hs.get(s.charAt(i));
            	if(num%2 ==0) count++;
            	else count--;
                hs.put(s.charAt(i), num+1);
            }
        }
        List<Character> mid = new ArrayList<Character>();
        List<Character> l = new ArrayList<Character>();
        for(char m:hs.keySet()){
        	int n = hs.get(m);
        	if(n%2==1){
        		mid.add(m);
        	}
        	for(int i=0; i<n/2; i++)
        		l.add(m);
        }
        dfs(l, new boolean[l.size()], new StringBuilder(), r,  mid);
        return r;
	}
	
	public static void dfs(List<Character> nums, boolean[] used, StringBuilder list, List<String> res,List<Character>  mid){
        if(list.length()== nums.size()){
        	StringBuilder s = new StringBuilder(list);
        	for(char middle:mid)
            res.add(s.toString() + middle + s.reverse().toString());
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(used[i]) continue;
            if(i>0 &&nums.get(i-1)==nums.get(i) && !used[i-1]) continue;
            used[i]=true;
            list.append(nums.get(i));
            dfs(nums,used,list,res,mid);
            used[i]=false;
            list.deleteCharAt(list.length()-1);
        }
    }

}
