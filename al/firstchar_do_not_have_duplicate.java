
public class firstchar_do_not_have_duplicate {

	public static void main(String[] args) {
		System.out.print(firstchar_do_not_have_duplicate("asdferadfse"));
	}
	
	public static int firstchar_do_not_have_duplicate(String s){
		int [] c = new int [26];
		for(char ch : s.toCharArray()){
			c[ch-'a']++;
		}
		for(int i=0;i<s.length();i++){
			if(c[s.charAt(i)-'a']==1) return i;
		}
		return -1;
	}

}
