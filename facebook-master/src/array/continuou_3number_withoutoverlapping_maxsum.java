import java.util.LinkedList;
import java.util.Queue;

public class continuou_3number_withoutoverlapping_maxsum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,7,7,2,1,1,4,8,8,6,1,1,9};
        System.out.println(maxThreeWindowSum(nums,2));
    }

    public static int maxWindowSum(int[] nums, int start, int end, int n) {
        if (nums == null || end - start+1 < n) throw new IllegalArgumentException();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        Queue<Integer> window = new LinkedList<>();
        for (int i = start; i <= end ; i++) {
            if(window.size() < n-1) {
                sum+=nums[i];
                window.offer(nums[i]);
            } else {
                sum+=nums[i];
                window.offer(nums[i]);
                max = Math.max(max,sum);
                sum-=window.poll();
            }
        }
        return max;
    }

    public static int maxThreeWindowSum(int[] nums, int n) {
        if (nums == null || nums.length < 3*n) throw new IllegalArgumentException();
        //move the window in the middle and find max window at both side;
        int max = Integer.MIN_VALUE;
        int middle = 0;
        Queue<Integer> window = new LinkedList<>();
        for (int i = n; i < nums.length-n; i++) {

            if(window.size() < n-1) {
                middle+=nums[i];
                window.offer(nums[i]);
            } else {
                middle+=nums[i];
                window.offer(nums[i]);
                int left = maxWindowSum(nums, 0, i-n, n);
                int right = maxWindowSum(nums, i+1, nums.length -1, n);
                max = Math.max(max, left + middle + right);
                middle-=window.poll();
            }
        }
        return max;
    }
}
