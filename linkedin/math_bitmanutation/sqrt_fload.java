package math_bitmanutation;

public class sqrt_fload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cubic((double)65535,10));
		System.out.println(Math.cbrt(65535));
	}
		
	public static double mySqrt(double x, int digit) {
		double start = 0;
		double end = x < 1 ? 1.0 : x;
		double diff = 1 / Math.pow(10, digit);
		while (start < end - diff) {
			double mid = start + (end - start) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid > x / mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return (start + end) / 2;
	}
	
	public static double cubic(double x, int digit) {
		double start = 0;
		double end = x < 1 ? 1.0 : x;
		double diff = 1 / Math.pow(10, digit);
		while (start < end - diff) {
			double mid = start + (end - start) / 2;
			if (mid * mid * mid == x ) {
				return mid;
			} else if (mid * mid * mid > x ) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return (start + end) / 2;
	}
	
	static float SqrtByBisection(int m) //用二分法 
	{ 
		float n = m;
		if(n<0) //小于0的按照你需要的处理 
			return n; 
		float mid,last; 
		float low,up; 
		low=0;
		up=n;
		int k = 2;
		double eps = Math.pow(10, -(k+1));
		mid=(low+up)/2; 
		do
		{
			if(mid*mid>n)
				up=mid; 
			else 
				low=mid;
			last=mid;
			mid=(up+low)/2; 
		}while(Math.abs(mid-last) > eps);//精度控制
		return mid; 
	} 

}
