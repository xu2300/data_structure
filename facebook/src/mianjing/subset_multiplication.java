import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subset_multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,3,4,5};
		int [] re = {2,3,4,5,6,8,10,12,15,20,24,30,40,60,120};
		for(int i : getProduct1(arr)){
			System.out.print(i+" ");
		}
	}
	
	public static List<Integer> getProduct1(int[] a){
		List<Integer> r = new ArrayList<Integer>();
		HashSet<Integer> s = new HashSet<Integer>();
		int len = a.length;
		int count = 1<<len;
		int re = 0;
		for(int i=1; i<count; i++){
			re = 0;
			for(int j =0; j<a.length; j++){
				if((i&(1<<j))!=0){
					if(re==0) re = 1 * a[j];
					else re =re*a[j];
				}
			}
			s.add(re);
		}
		r.addAll(s);
		Collections.sort(r);
		return r;
	}
		
	public static List<Integer> getProduct(int[] a){
		List<Integer> re = new ArrayList<Integer>();
		HashSet<Integer> s = new HashSet<Integer>();
		helper(s,0,0,a);
		re.addAll(s);
		Collections.sort(re);
		return re;
	}
	public static void helper(Set<Integer> s, int start,int num,int[] a){
		if(num!=0){
			s.add(num);
		}
		int next = 0;
		for(int i=start; i<a.length;i++){
			if(num==0) next = 1*a[i];
			else next = num*a[i];
			helper(s,i+1,next,a);
		}
	}
	
	
	

}
