package math_bitmanutation;

public class log2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getIntegralPart (float n) {
	    if (n <= 0) {  // invalid input
	        return -1;
	    }
	    int result = 0;
	    int num = (int)n;
	    while ((num >>= 1) != 0) {
	        ++result;
	    }
	    return result;
	}

}
