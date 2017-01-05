
public class prePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {6,3,7,1,4,8,9};
		nextPermutation(nums);
		for(int i :nums)
		System.out.print(i);
		//6，3，7，1，4，8，9
		//6，3，4，9，8，7，1
	}
	
	public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-1;
        while(i>=1){
            if(nums[i] >= nums[i-1]) i--;
            else break;
        }
        i--;
        if(i>=0){
            int j = n-1;
            while(nums[j]>=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,++i, n-1);
    }
    
    public static void reverse(int [] nums, int i, int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
    
    public static void swap(int[]nums , int i, int j){
        int r = nums[i];
        nums[i] = nums[j];
        nums[j] = r;
    }

}
