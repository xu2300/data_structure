package backtracking;

import java.util.*;

public class Longest_Palindrome_all_the_result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//可以delete，重新排序
		for(String s: one_longest_palidrome("atatdc")){
			System.out.println(s);
		}
	}
	
	public static List<String> one_longest_palidrome(String s){
		List<String> r= new ArrayList<String>();
		if(s==null || s.length()==0) return r;
        HashMap<Character,Integer> hs = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c,0)+1);
        }
        int count = 0;
        HashMap<Character,Integer> mid = new HashMap<>();
        HashSet<Character> l = new HashSet<>();
        for(char m:hs.keySet()){
        	int n = hs.get(m);
        	if(n%2==1){
        		l.add(m);
        	}
        	count += n/2;
            mid.put(m,n/2);
        }
        dfs(mid,new StringBuilder(), r, l, count);
        return r;
	}
	
	public static void dfs(HashMap<Character,Integer> mid, StringBuilder list, List<String> r, HashSet<Character> l, int count){
        if(list.length() == count){
            for(char c : l){
                StringBuilder cur = new StringBuilder(list);
                r.add(cur.toString()+c+cur.reverse().toString());
            }
            return;
        }
        for(char c : mid.keySet()){
            int n = mid.get(c);
            if(n ==0) continue;
            mid.put(c,n-1);
            list.append(c);
            dfs(mid,list, r, l, count);
            list.deleteCharAt(list.length()-1);
            mid.put(c,n);
        }
    }

}
