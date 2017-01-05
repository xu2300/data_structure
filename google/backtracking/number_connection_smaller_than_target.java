package backtracking;
import java.util.*;
public class number_connection_smaller_than_target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(3,7,8));
		int target = 8700;
		for(int i :smaller(l, target)){
			System.out.print(i+" ");
		}
	}
	/*
	2.给你一个数字的list，然后给一个target，求所有由list里面数字组合成的小于target的数，数字可以重复使用
	比如list是{3,7,8}，target是8700，然后3, 8, 7 ... 333, 888, ... , 8377 等等都算
	*/
	public static Set<Integer> smaller(List<Integer> l, int target){
	    Set<Integer> set = new HashSet<Integer>();
	    help(l,target,set,0);
	    return set;
	}

	public static void help(List<Integer> l, int target, Set<Integer> re, int cur){
	    if(cur !=0 && cur<target){
	        re.add(cur);
	    }
	    if(cur>=target) return;
	    int size = l.size();
	    for(int i =0; i<size; i++){
	        int num = l.get(i);
	        int numberOfDigit = 1;
	        int newNum = num;
	        while(newNum/10 != 0){
	            numberOfDigit++;
	            newNum /= 10;
	        }
	        int numberOfZero  =(int) Math.pow(10,numberOfDigit);
	        cur= cur * numberOfZero + num;
	        help(l,target,re,cur);
	        cur= cur/numberOfZero;
	    }
	}
}
