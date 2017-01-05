import java.util.ArrayList;
import java.util.List;

public class plus{

    public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String num = "123456789";
        int target = 100;
        for(String i:result(num,target))
        System.out.println(i);
    }

    public static List<String> result(String num, int target){
        List<String> re = new  ArrayList<String>();
        if(num == null) return re;
        helper(re,target,Long.parseLong(num.substring(0,1)),num.substring(0,1),1,num);
        return re;
    }

    public static void helper(List<String> re, int target, long value, String sb,
            int start,String num){
    	if(start == num.length()){
            if(target == value)
    		re.add(sb.toString());
            return;
        }
        for(int i = start; i< num.length(); i++){
            long cur = Long.parseLong(num.substring(start,i+1));
            helper(re,target,value+cur,sb+"+"+num.substring(start,i+1),i+1,num);
            helper(re,target,value-cur,sb+"-"+num.substring(start,i+1),i+1,num);
        }
    }
}

