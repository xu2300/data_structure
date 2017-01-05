package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_path {


	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(2));
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(3,4));
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(6,5,7));
		List<Integer> l3 = new ArrayList<Integer>(Arrays.asList(4,1,8,3));
		List<List<Integer>> sum = new ArrayList<List<Integer>>();
		sum.add(l);sum.add(l1);sum.add(l2);sum.add(l3);
		for(int i : Traigle(sum)){
			System.out.println(i);
		}
	}
		
	public static List<Integer> Traigle(List<List<Integer>> triangle){
	    List<List<Integer>> sum = new ArrayList<List<Integer>>();
	    int size = triangle.size();
	    List<Integer> l = new ArrayList<Integer>();
	    for(int i=0; i<size; i++){
	        l.add(triangle.get(size-1).get(i));
	    }
	    sum.add(l);
	    for(int i = size-2; i>=0; i--){
	    	List<Integer> line = new ArrayList<Integer>();
	        for(int j=0; j<=i; j++){
	            line.add(triangle.get(i).get(j) + Math.min(sum.get(0).get(j),  sum.get(0).get(j+1)));
	        }
	        sum.add(0,line);
	    }
	    List<Integer> re = new ArrayList<Integer>();
	    int index = 0;
	    for(int i=0; i<size; i++){
	        re.add(triangle.get(i).get(index));
	        if(i+1<size){
	            index = sum.get(i+1).get(index) < sum.get(i+1).get(index+1) ? index:index+1;
	        }
	    }
	    return re;
	}


}
