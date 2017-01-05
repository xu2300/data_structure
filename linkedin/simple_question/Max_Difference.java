package simple_question;

/*给整数 x[0], x[1], ... x[n]， 找 i<j, 使 x[i] - x[j] 最大*/
public class Max_Difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,7,3,2,0,5,-2};
		System.out.println(max(a));
	}
	
	public static int max(int[] a){
		int len = a.length;
		int maxvalue = Integer.MIN_VALUE;
		int min =a[len-1];
		for(int i = len-2; i>=0; i--){
			maxvalue = Math.max(a[i] - min, maxvalue);
			min = Math.min(min, a[i]);
		}
		return maxvalue == Integer.MIN_VALUE? -1: maxvalue;
	}

}
