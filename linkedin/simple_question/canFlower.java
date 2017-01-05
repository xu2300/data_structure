package simple_question;
/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not.
However, flowers cannot be planted in adjacent plots -they would compete for water and both would die.
Given a flowerbed (represented as an array containingbooleans), return if a given number of new flowers can be planted in it without violating the no-adjacent-flowers rule.
  0 0 0 0 0 0
      canPlaceFlowers(1)=true; canPlaceFlowers(2)=true; canPlaceFlowers(3)=true; canPlaceFlowers(4)=false
  1 0 1 1 1 0
      canPlaceFlowers(1) == false;
  1 0 0 0 1
      canPlaceFlowers(1) == true; canPlaceFlowers(2) == false;
followup: what if no random access to the list is permitted
*/

public class canFlower {

	public static boolean canPlaceFlower(int[] plots, int num) {
	    if (plots == null) {
	        return false;
	    }
	    int count = 0;
	    for (int i = 0; i < plots.length; ++i) {
	        if (plots[i] == 1) {
	            continue;
	        }
	        if (i == 0) {  // first plot
	            if (i + 1 < plots.length && plots[i + 1] == 0) {  // can plant if next plot is empty
	                ++count;
	                plots[i] = 1;
	            }
	        } else if (plots[i - 1] == 0) {  // not first plot, and previous plot is empty          // then check next plot. If no next plot or next plot is empty, can plant
	            if (i + 1 == plots.length || (i + 1 < plots.length && plots[i + 1] == 0)) {
	                ++count;
	                plots[i] = 1;
	            } 
	        }
	        if (count == num) {
	            return true;
	        }
	    }
	    return false;
	}
	

}
