
public class countWords {

	public static void main(String[] args) {
		System.out.println(countWords("hello qwer qwer world"));
	}
	
	public static int countWords(String s){
		int n = s.length();
		int count = 0;
		if(Character.isLetter(s.charAt(0))) count++;
		for(int i =0;i<n;i++){
			if(i!=0 && Character.isLetter(s.charAt(i)) &&
				!Character.isLetter(s.charAt(i-1))){
				count++;
			}
		}
		return count;
	}

}
