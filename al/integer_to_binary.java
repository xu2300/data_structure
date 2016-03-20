

public class integer_to_binary {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "001111111111111";
		System.out.println(tos(s));
	}
	
	public static int tos(String s){
		char []str = s.toCharArray();
		int re = 0;
		int digit =0;
		for(int i = 0; i<str.length; i++){
			if(str[i] == '1') digit =1;
			else digit = 0;
			re = (re <<1) + digit;
		}
		return re;
	}
}
