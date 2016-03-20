

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class two_sum_pairs {

	public static void main(String[] args) {
		int [] num = {1,1,1,1,1,1,1,1};
		System.out.println(twosum(num,2));
	}
	
    public static List<List<Integer>> twosum(int [] num, int sum){
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int n : num){
            if(map.containsKey(sum-n)){
                List<Integer> l = new ArrayList<Integer>();
                l.add(n);
                l.add(sum-n);
                r.add(l);
                if(map.get(sum-n) == 1) map.remove(sum-n);
                else map.put(sum-n, map.get(sum-n)-1);
            }
            else{
                if(map.containsKey(n)) map.put(n, map.get(n)+1);
            map.put(n,1);
            }     
        }
        return r;
    }
}
