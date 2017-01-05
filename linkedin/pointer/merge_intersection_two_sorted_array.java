package pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class merge_intersection_two_sorted_array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,1,1,2,6,7,8));
	     List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,1,3,7,9));
	     List<Integer> re = merge(list1,list2);
	     for(int i: re){
	    	 System.out.print(i);
	    	 System.out.print(" ");
	     }
	     
	}
	
	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		List<Integer> answer = new ArrayList<Integer>();
	    int i = 0, j = 0;
	    int asize = a.size();
	    int bsize = b.size();
	    while (i < asize && j < bsize)
	    {
	        if (a.get(i) < b.get(j))       
	            answer.add(a.get(i++));
	        else        
	        	answer.add(b.get(j++));          
	    }
	    while (i < asize)  
	    	answer.add(a.get(i++));
	    while (j < bsize)    
	    	answer.add(b.get(j++));
	    return answer;
	}
	
	public static List<Integer> intersection(List<Integer> a, List<Integer> b)
	{
		List<Integer> answer = new ArrayList<Integer>();
	    int i = 0, j = 0;
	    int asize = a.size();
	    int bsize = b.size();
	  while (i < asize && j < bsize){
		 if (a.get(i) < b.get(j))      
	      i++;
	    else if (a.get(i) > b.get(j))
	      j++;
	    else /* if arr1[i] == arr2[j] */
	    {
	      //if(! (i!=0 && j!=0 && a.get(i) == a.get(i-1) && b.get(j) == b.get(j-1) ))
	    	  answer.add(a.get(i));
	      i++;
	      j++;
	    }
	  }
	  return answer;
	}
	
	
	public static List<Integer> merge1(List<Integer> a, List<Integer> b) {
		//[1, 1, 1, 2 ]和[1, 1 , 3]要return [1, 1,1, 2, 3]
		List<Integer> answer = new ArrayList<Integer>();
	    int i = 0, j = 0;
	    int asize = a.size();
	    int bsize = b.size();
	    while (i < asize && j < bsize)
	    {
	        if (a.get(i) < b.get(j))       
	            answer.add(a.get(i++));
	        else {      
	        	answer.add(b.get(j++));  
	        	i++;
	        }
	    }
	    while (i < asize)  
	    	answer.add(a.get(i++));
	    while (j < bsize)    
	    	answer.add(b.get(j++));
	    return answer;
	}
}
