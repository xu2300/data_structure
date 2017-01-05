package maP_method;

import java.util.*;

/*给我一堆unsorted数字，问我可不可以等分成若干组，每组由五个连续的整数组成。
eg: 1,2,3,4,5,4,5 -> false
1,2,3,4,5,2,3,4,5,6 ->true
follow up: 问我可不可以等分成若干组，每组由五个重复数组成。
follow up2: 每组由k个连续数组成。   k>=3
 */
public class k_consective_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isValid_five(int[] nums) {
        if (nums == null || nums.length < 5) {
                return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i])+1 : 1);
        }

        while (map.size() > 0) {
                int t = map.firstKey();
                int length = 0;
                while (length < 5 && map.containsKey(t)) {
                        map.put(t, map.get(t)-1);
                        if (map.get(t) == 0) {
                                map.remove(t);
                        }
                        t++;
                        length++;
                }
                if (length < 5) {
                        return false;
                }
        }
        return true;
}

}
