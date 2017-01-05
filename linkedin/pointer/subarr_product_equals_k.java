package pointer;

public class subarr_product_equals_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1, -2, 3, 4, -5, 6 };
		int k = -60;
		System.out.print(product(a,k));
	}
	
	public static boolean product(int [] a, int k){
		int len = a.length;
		int absk = Math.abs(k);
		if(len ==0) return false;
		int flag =1;
		int max = 1;
		int end = 0;
		int start = 0;
		while(end!=len){
			max = max* Math.abs(a[end]);
			flag = a[end] > 0? flag: -flag;
			if(max * flag == k) return true;
			if(max<absk) {
				end++;
				continue;
			}
			while(max>absk && start<end){
				max /= Math.abs(a[start]);
				flag = a[start] > 0? flag: -flag;
				start++;
			}
			if(max * flag == k) return true;
			end++;
		}
		return false;
	}

}
