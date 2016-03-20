

public class compress_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("asdfgeeesss"));
	}
	
    public static String compress(String s){
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int count =1;
        char ch = s.charAt(0);
        for(int i =1; i<len; i++){
            if(s.charAt(i) == ch) count ++;
            else{
                if(count!=1) sb.append(count);
                sb.append(ch);
                ch = s.charAt(i);
                count  = 1;
            }
        }
        if(count != 1) sb.append(count);
        sb.append(ch);
        return sb.toString();
    }

}
