package simple_question;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
/*Find all the repeating sub-string sequence of specified length in a large string sequence. 
 * The sequences returned i.e. the output must be sorted alphabetically.
For example:
  Input String: "ABCACBABC", repeated sub-string length: 3 
  Output: ABC

  Input String: "ABCABCA", repeated sub-string length: 2 
  Output: AB, BC, CA*/
public class Find_Repeating_Substring {
	public static void printRepeatingStrings(String inputString, int sequenceLength) {
	    if (inputString.isEmpty() || sequenceLength <= 0 || sequenceLength >= inputString.length()) {
	        return ;
	    }
	    Set<String> subStringSet = new HashSet<String>();
	    Set<String> repeatingSequences = new TreeSet<String>();
	    for (int i = 0; i + sequenceLength <= inputString.length(); ++i) {
	        int j = i + sequenceLength;
	        String subString = inputString.substring(i, j);
	        if (!subStringSet.contains(subString)) {
	            subStringSet.add(subString);
	        } else {
	            repeatingSequences.add(subString);
	        }
	    }
	    for (String str : repeatingSequences) {
	        System.out.println(str);
	    }
	}

	public static void main(String[] args) {
	    printRepeatingStrings("ABABABC", 2);
	    printRepeatingStrings("ABABBABBZEDZEDZE", 3);
	    printRepeatingStrings("AAGATCCGTCCCCCCAAGATCCGTC", 10);
	}
}
