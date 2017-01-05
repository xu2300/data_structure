package backtracking;

public class Print_Factor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFactors(32);
	}
	
	 public static void printFactors(int n) {
	        if (n < 1) {
	            return;
	        }
	        System.out.println(1 + " * " + n);
	        helper("", n, 2);
	    }

	  private static void helper(String str, int n, int start) {
	        if (n == 1) {
	            return;
	        }
	        for (int factor = start; factor <= Math.sqrt(n); ++factor) {
	            if (n % factor == 0) {
	                System.out.println(str + factor + " * " + n / factor);
	                helper(str + factor + " * ", n / factor, factor);
	            }
	        }
	  }
	  


}
