import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class number_occurence_odd_number_times {

	public static void main(String[] args) {
		List<Integer> l= new ArrayList<Integer>();
		l.add(1);l.add(1);
		l.add(2);l.add(1);l.add(2);l.add(2);l.add(2);
		System.out.print(odd(l));
	}
	
	public static List<Integer> odd(List<Integer> input){
		Collections.sort(input);
		List<Integer> r= new ArrayList<Integer>();
		if(input.size() == 0) return r;
		int n = input.size();
		boolean odd = true;
		int pre = input.get(0);
		for(int i =1;i<n;i++){
			if(input.get(i) == pre){
				odd = !odd;
			}
			else{
				if(odd) r.add(pre);
				pre = input.get(i);
				odd = true;
			}
		}
		if(odd) r.add(pre);
		return r;
	}

}
