package dp;


public class longest_consective_subarray {
    public static int longest_number(int[] num){
        int len = num.length;
        if(len ==0) return 0;
        int pre = num[0];
        int count = 1;
        int max = 1;
        for(int i= 1; i<len; i++){
            if(num[i] == pre+1) {
                count++;
                max = Math.max(max,count);
            }
            else{
                count = 1;
            }
            pre = num[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int [] re = {1,2,3,1};
        System.out.print(longest_number(re));
    }
}
