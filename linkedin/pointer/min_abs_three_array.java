package pointer;

public class min_abs_three_array {
/*
 * Given three sorted arrays A[], B[] and C[], 
 * find 3 elements i, j and k from A, B and C
 *  respectively such that max(abs(A – B[j]), abs(B[j] – C[k]), abs(C[k] – A)) is minimized. 
 *  Here abs() indicates absolute value.
Example : 
Input: A[] = {1, 4, 10}  B[] = {2, 15, 20} C[] = {10, 12} 
Output: 10 15 10。 10 from A, 15 from B and 10 from C
Input: A[] = {20, 24, 100} B[] = {2, 19, 22, 79, 800} C[] = {10, 12, 23, 24, 119} 
Output: 24 22 23。24 from A, 22 from B and 23 from C
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {20, 24, 100};
		int [] b = {2, 19, 22, 79, 800};
		int [] c = {10, 12, 23, 24, 119} ;
		int [] r= abs_min(a,b,c);
		System.out.println(a[r[0]] + " " + b[r[1]] + " " + c[r[2]]);
	}
	
	public static int[] abs_min(int[]a, int[] b, int [] c){
		int [] r= new int [3];
		int i = 0, j=0, k =0;
		int lena = a.length, lenb = b.length, lenc = c.length;
		int min = Integer.MAX_VALUE;
		while(i<lena && j<lenb && k< lenc){
			int localmin = Math.min(a[i], Math.min(b[j], c[k]));
			int localmax = Math.max(a[i], Math.max(b[j], c[k]));
			int curmin = localmax - localmin;
			if(curmin < min){
				min = curmin;
				r[0] = i;
				r[1] = j;
				r[2] = k;
			}
			if(a[i] == localmin)
				i++;
			else if(b[j] == localmin)
				j++;
			else k++;
		}
		return r;
	}

}
