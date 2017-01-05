package simple_question;

	/*You have two arrays of integers, where the integers do not repeat and the two arrays have no common integers.
Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)). That is, find the smallest difference between any of the integers in the two arrays.
Assumptions: Assume both arrays are sorted in ascending order*/
	public class min_abs {
		
		public static int minAbs(int[] a, int[] b) {
		    if (a == null || b == null || a.length == 0 || b.length == 0) {
		        return -1;
		    }
		    int i = 0, j = 0;
		    int minAbs = Integer.MAX_VALUE;
		    while (i < a.length && j < b.length) {
		        if (a[i] < b[j]) {
		            minAbs = Math.min(minAbs, b[j] - a[i]);
		            ++i;
		        } else if (a[i] > b[j]){
		            minAbs = Math.min(minAbs, a[i] - b[j]);
		            ++j;
		        } else {  // cannot be smaller
		            minAbs = 0;
		            break;
		        }
		    }
		    return minAbs;
		}
}
	
	

