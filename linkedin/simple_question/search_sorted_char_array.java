package simple_question;

public class search_sorted_char_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] re = {'a','b','g','j'};
		System.out.print(help(re,'f'));
	}
	
	public static int help(char[] re, char target){
		int l = 0;
		int h = re.length-1;
		while(l<=h){
			int m = l+ (h-l)/2;
			if(re[m] > target) {
				h = m-1;
			}
			else{
				l = m+1;
			}
		}
		return l  == re.length? 0: l;
	}

}
