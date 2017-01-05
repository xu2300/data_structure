package goo;

import java.util.*;

public class palidrome_string_by_deleting_any_letter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s: getAllPalidrome("abaaa",0,4,new HashMap<Integer, Set<String>>())){
			System.out.println(s);
		}
	}
	
	public static Set<String> getAllPalidrome(String s, int x, int y, Map<Integer, Set<String>> allSubSet){
	  int ind = x * s.length() + y;
	  if(allSubSet.containsKey(ind)) return allSubSet.get(ind);
	  Set<String> ret = new HashSet<String>();
	  if  (y<x) { ret.add(""); return ret;}
	  if (x==y) { ret.add(""+s.charAt(x)); return ret;}
	  for(int i = x; i <=y; i++){
	    for (int j = y; j >= i; j--){
	      Set<String> subSet = getAllPalidrome(s, i + 1, j - 1,allSubSet);
	      if(!subSet.contains("")) ret.addAll(subSet);
	      if (s.charAt(i) == s.charAt(j) ){
	          if(i!=j){
	        	  for (String str : subSet) ret.add(s.charAt(i) + str + s.charAt(i));
	          }
	          else ret.add(""+s.charAt(i));
	      }
	    }
	  }
	  allSubSet.put(ind, ret);
	  return ret; 
	}
}
