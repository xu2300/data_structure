

public class merge_array_without_dup {

	public static void main(String[] args) {
		int [] a = new int[]{1,2,2,2,3,5,7};
		int [] b = new int[] {2,3,4,4,5,7};
		int [] m = merge(a,b);
		for (Integer element : m){
	         System.out.printf("%s ", element);
	      }
	}
	public static int [] merge(int[] a, int[] b ){ 
		int m = a.length;
		int n = b.length;
		int[] r = new int [m+n];
		int i = 0;
		int j = 0;
		int s = 0;
		while(i < m && j < n){
			if(a[i] < b[j]){
				if(s==0 || a[i]!=r[s-1]){
					r[s++] = a[i++];
				}
				else i++;
			}
			else{
				if(s==0 || b[j]!=r[s-1]){
					r[s++] = b[j++];
				}
				else j++;
			}
		}
			
		while(i<m){
			if( a[i]!=r[s-1]){
				r[s++] = a[i++];
			}
			else i++;
		}
		
		while(j<n){
			if( b[j]!=r[s-1]){
				r[s++] = b[j++];
			}
			else j++;
		}
		return r;
	}
	
}
