

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class the_largest_n_fabonacii_smaller_than_n {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonaci(100,3));
	}
	
	public static Queue<Integer> fibonaci(int m, int n){
		int a = 0;
		int b = 1;
		int sum =0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		q.offer(1);
		while(sum<m){
			q.offer(sum);
			sum = a+b;
			a = b;
			b = sum;
			while(q.size()>n)q.poll();
		}
		return q;
	}

}
