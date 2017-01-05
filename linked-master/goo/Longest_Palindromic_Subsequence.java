package goo;

public class Longest_Palindromic_Subsequence {
	/* Write a function to compute the maximum length palindromic sub-sequence of an array. 
	 A palindrome is a sequence which is equal to its reverse. 
	 A sub-sequence of an array is a sequence which can be constructed by removing elements of the array. 
	 Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's) 
			 / class Interview { public static int maxLengthPalindrome(int[] values) { 
				 //ur implementation here } 
				  **/



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};
		System.out.println(help(arr));
	}
	//dp[i][j] = dp[i+1][j-1] + 2 if values[i] == values[j]
	//dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]), otherwise, expand from len - 1.
	public static int help(int[] arr){
		int len = arr.length;
		int [][] dp = new int[len][len];
		for(int i=0; i<len; i++) dp[i][i] = 1;
		for(int l =1; l<len; l++){
			for(int i=0; i+l<len; i++){
				int j = i+l;
				if(arr[i] == arr[j]){
					if(i==j-1){
						dp[i][j] = 2;
					}
					dp[i][j] = dp[i+1][j-1] + 2;
				}
				else{
					
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		return dp[0][len-1];
	}

}
