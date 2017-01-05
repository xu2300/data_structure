package lab1;

public class word_abbrevation_conpressConsectiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(help("appleeefe"));
	}
	/*给一个字符串的abbreviation ，就是把一些连续的字符转成数字，比如apple -> a2l1 , 
	然后让写一个函数验证一个带数字缩写是不是另一个字符串的缩写。two pointer秒过*/
	public static String help(String s){
		StringBuilder sb = new StringBuilder();
		char [] str = s.toCharArray();
		char pre = str[0];
		int num = 1;
		for(int i =1; i<str.length; i++){
			if(str[i] == pre){
				num++;
				continue;
			}
			else{
				if(num!=1) sb.append(num);
				else sb.append(pre);
				pre = str[i];
				num =1;
			}
		}
		if(num!=1) sb.append(num);
		else sb.append(pre);
		return sb.toString();
	}

}
