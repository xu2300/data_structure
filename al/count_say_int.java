

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class count_say_int {

	public static void main(String[] args) {
		int [] array = {1,0,1,0};
		System.out.println(count(array));
	}
	
	public static List<Integer> count(int[] array){
		List<Integer> r = new ArrayList<Integer>();
		if(array.length == 0) return r;
		int say=array[array.length-1];
		int count = 1;
		for(int i=array.length-2; i>=0; i--){
			if(array[i]==say){
				count++;
			}
			else{
				r.add(count);
				r.add(say);
				count =1;
				say = array[i];
			}
		}
		r.add(count);
		r.add(say);
		Collections.reverse(r);
		return r;
	}

}
