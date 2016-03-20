

import java.util.HashMap;
import java.util.Map;

public class least_index_of_first_appereance_char_in_string {

	public static void main(String[] args) {
		System.out.print(help("asdferadfse"));
	}
	
	public static char help(String s){
		Map<Character,Integer> set = new HashMap<Character,Integer>();
		for(int i =0; i<s.length();i++){
			if(!set.containsKey(s.charAt(i))) set.put(s.charAt(i), 1);
			else set.put(s.charAt(i), set.get(s.charAt(i))+1);
		}
		for(int i =0; i<s.length();i++){
			if(set.get(s.charAt(i)) == 1) return s.charAt(i);
		}
		return 0;
	}

}
