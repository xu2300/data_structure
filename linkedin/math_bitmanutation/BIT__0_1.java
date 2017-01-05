package math_bitmanutation;

public class BIT__0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		for(int i =1; i<=31; i++){
			System.out.println(a);
			a = nextnum(a);
		}
	}
	
	public static int nextnum(int n){
		int mask = 3;
		int x = 1;
		for(int i =0; i<= 30;i++){
			if((n & mask) == 0) break;
			mask<<=1;
			x<<=1;
		}
		n |= x;
		n &= ~(x-1);
		return n;
	}
}
