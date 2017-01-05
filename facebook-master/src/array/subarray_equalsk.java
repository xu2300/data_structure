import java.util.HashMap;
import java.util.HashSet;

public class subarray_equalsk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[]re = {100,1,23,5,2,2222};
        System.out.println(equalk(re,2224));
	}
	
	public static boolean equalk(int[] num, int k){
		int l =-1;
		int h = -1;
		int len = num.length;
		if(len == 0) return false;
		int sum =0;
		while(l<len){
			if(sum<k){
				if(++h<len){
					sum+=num[h];
				}
				else return false;
			}
			else if(sum > k){
				if(++l<=h){
					sum-=num[l];
				}
			}
			else return true;
		}
		return false;
	}

}
