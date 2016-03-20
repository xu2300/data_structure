package amazon;

public class add_binary {

	public static void main(String[] args) {
		int [] a = {1,1};
		int [] b = {1};
		int [] r = add_binary_array(a,b);
		for(int i =0; i<r.length; i++)
		System.out.print(r[i]);
	}
	
	public static int [] add_binary_array(int [] a , int [] b){
		int m = a.length;
		int n = b.length;
		int [] r = new int [Math.max(m,n)+1];
		int carry = 0;
		int i = 0;
		int sum = 0;
		while(carry!=0 || i<m || i<n){
			sum = carry + (i<m?a[i]:0) + (i<n?b[i]:0);
			carry = (sum>=2? 1: 0);
			sum %=2;
			r[i++] = sum;
		}
		return r;
	}
	
}
