package pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class merge_iterator_intersection_iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,4,5,6));
	     List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(2,3,5,7,8,9));
	     Iterator<Integer> re = intersection(list1.iterator(),list2.iterator());
	     while(re.hasNext()){
	    	 System.out.print(re.next());
	    	 System.out.print(" ");
	     }
	     
	}
	public static Iterator<Integer> intersection(Iterator<Integer> l1, Iterator<Integer> l2){
		List<Integer> re = new ArrayList<>();
	    if(!l1.hasNext()) return re.iterator();
	    if(!l2.hasNext()) return re.iterator();;
	    int s1 = l1.next(), s2 = l2.next();
	    
		while(true){
			if(s1>s2){
				if(!l2.hasNext()){
					return re.iterator();
				}
				s2 = l2.next();
			}
			else if(s2>s1){
				if(!l1.hasNext()){
					return re.iterator();
				}
				s1 = l1.next();
			}
			else{
				re.add(s1);
				if(!l2.hasNext()|| !l1.hasNext()){
					return re.iterator();
				}
				s1 = l1.next();
				s2 = l2.next();
			}
		}
	}
	
	private static Iterator<Integer> combine(Iterator<Integer> l1,Iterator<Integer> l2) {
	    List<Integer> re = new ArrayList<>();
	    if(!l1.hasNext()) return l2;
	    if(!l2.hasNext()) return l1;
	    int s1 = l1.next(), s2 = l2.next();
	    while (true) {
            if (s1 < s2) { // s1 comes before s2
                re.add(s1);
                if(!l1.hasNext()) {
                	re.add(s2);
                	break;
                }
                s1 = l1.next();
            }
            else { // s1 and s2 are equal, or s2 comes before s1
            	re.add(s2);
                if(!l2.hasNext()) {
                	re.add(s1);
                	break;
                }
                s2 = l2.next();
            }
        }

        // There is still at least one element from one of the lists which has not been added
	    while (l1.hasNext()) {
	    	re.add(l1.next());
        }
	    
	    while (l2.hasNext()) {
	    	re.add(l2.next());
        }
	    return re.iterator();
	}
	
}
