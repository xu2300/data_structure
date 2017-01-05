package backtracking;

import java.util.ArrayList;
import java.util.List;

public class app_1_com {
	    public static List<String> concat(String s) {
	        List<String> result = new ArrayList<String>();
	        helper(s, 0, result, "");
	        return result;
	    }
	    
	    private static void helper(String s, int start, List<String> result, String pre) {
	        if (start >= s.length()) {
	            result.add(pre);
	            return;
	        }
	        int open = s.indexOf('[', start);
	        int close = s.indexOf(']', start);
	        if (open == -1 || close == -1) {
	            helper(s, s.length(), result, pre + s.substring(start));
	        }
	        else {
	            List<Integer> numbers = parseString(s.substring(open + 1, close));
	            for (int i = 0; i < numbers.size(); i++) {
	                helper(s, close + 1, result, pre + s.substring(start, open) + numbers.get(i));
	            }
	        }
	       
	    }
	    
	    private static List<Integer> parseString(String input) {
	        List<Integer> list = new ArrayList<Integer>();
	        int i = 0;
	        while (i < input.length()) {
	            int comma = input.indexOf(',', i);
	            if (comma == -1) comma = input.length();
	            list.add(Integer.parseInt(input.substring(i, comma)));
	            i = comma + 1;
	        }
	        return list;
	    }
	    
	    public static void main(String[] args) {
	        String s = "app[1,2].corp[3,4].goo[5,6].com";
	        List<String> result = concat(s);
	        for (String w : result) {
	            System.out.println(w);
	        }
	    }

}
