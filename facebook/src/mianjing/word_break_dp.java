import java.util.HashSet;
import java.util.Set;

public class word_break_dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	HashSet<String> s = new HashSet<String>();
    	s.add("Google");s.add("Facebook");s.add("Microsoft");s.add("GoogleFace"); s.add("bookMicsoft");
    	String ss  = "GoogleFacebookMicrosoft";
    	System.out.println(wordBreak(ss,s));

	}
	
    public static String wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean []re = new boolean[n+1];
        re[0] = true;
        int [] word = new int [n+1];
        for(int i =1; i<=n;i++){
            for(int j =0;j<i;j++){
                if( wordDict.contains(s.substring(j,i)) && re[j]){
                    re[i] = true;
                    word[i] = j;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int num = n;
        while(num!=0){
        int index = word[num];
        sb = sb.insert(0,s.substring(index,num));
        num = index;
        }
        return sb.toString();
    }

}
