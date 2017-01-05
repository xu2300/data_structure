package greedy;

import java.util.*;

public class String_k_part {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababj"; 
		int k = 3;
		for(String str:k_part(s,4)){
			System.out.println(str);
		}
	}
	
	public static List<String>  k_part(String s, int k){
		int len = s.length();
		int i =0, start = 0;
		List<String> re= new ArrayList<String>();
		HashSet<Character> set = new HashSet<Character>();
		while(i<len && k>1){
			start = i;
			set.add(s.charAt(start));
			i++;
			while(i<len && set.contains(s.charAt(i))) i++;
			if(i==len) return new ArrayList<String>();
			re.add(s.substring(start, i));
			k--;
		}
		re.add(s.substring(i));
		return re;
	}

}
