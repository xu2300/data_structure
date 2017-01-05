package simple_question;

public class Common_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int countCommonCharacters(String[] inputs) {
	    if (inputs == null || inputs.length == 0) {
	        return 0;
	    }
	    int[] count = new int[26];
	    for (String input: inputs) {
	        boolean[] appeared = new boolean[26];
	        for (int i = 0; i < input.length(); ++i) {
	            int index = input.charAt(i) - 'a';
	            if (!appeared[index]) {
	                appeared[index] = true;
	                ++count[index];
	            }
	        }
	    }
	    int result = 0;
	    for (int i = 0; i < 26; ++i) {
	        if (count[i] == inputs.length) {
	            ++result;
	        }
	    }
	    return result;
	}
}
