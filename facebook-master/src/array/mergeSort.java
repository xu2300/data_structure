import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 6, 3, 5, 1, 9,10,4,4,3 };
        
        //Call merge sort
        mergesort(a);
         
        //Check the output which is sorted array
        System.out.println(Arrays.toString(a));
	}
	
	public static int[] mergesort(int[] re){
		if(re.length<=1) return re;
		int len = re.length;
		int[] f = new int[len/2];
		int[] s = new int[len-f.length];
		System.arraycopy(re,0,f,0,f.length);
		System.arraycopy(re, f.length, s, 0, s.length);
		mergesort(f);
		mergesort(s);
		merge(f,s,re);
		return re;
	}
	
	public static void merge(int[]f,int[]s,int[]r){
		int fp = 0,sp =0, mp = 0;
		while(fp<f.length && sp<s.length){
			if(f[fp]<s[sp]){
				r[mp++] = f[fp++];
			}
			else{
				r[mp++] = s[sp++];
			}
		}
		System.arraycopy(f, fp, r, mp, f.length-fp);
		System.arraycopy(s, sp, r, mp, s.length-sp);
	}
}
