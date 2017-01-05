package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoppingIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	int hop = 0;
	T cache = null ;
	public HoppingIterator(Iterator<T> iterator, int numHops) {
			this.iterator = iterator;
			hop = numHops;
			cache = iterator.next();
	}
		
	public boolean hasNext() {
		return cache != null;
	} 
		
	public T next() {
		T re = cache;
		int num = hop;
		while(num+1 !=0 && iterator.hasNext()){
			cache = iterator.next();
			num--;
		}
		if(num!=-1) cache = null;
		return re;
	}
	
	public static void main(String[] args) 
    {
		List<Integer> r= new ArrayList<Integer>();
		r.add(1);r.add(2);r.add(3);r.add(4);r.add(5);
		Iterator<Integer> i = r.iterator();
		HoppingIterator<Integer> h = new HoppingIterator<Integer>(i,1);
		System.out.print(h.next());
		System.out.print(h.next());
		System.out.print(h.hasNext());
		//System.out.print(h.next());
    }
}


