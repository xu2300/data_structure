
public class _2D_subarray_equalsk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [][] array = {
							  {1 ,5 ,7},
			                  {3 ,7 ,8},
			                  {4, 8 ,9},
			};
			
			System.out.println(submatrixSum(array,16));
	}
	
	public static boolean submatrixSum(int[][] matrix,int target) {
        // Write your code here
        int len = matrix.length;
        int leny = matrix[0].length;
        if(len == 0 || leny ==0) return false;
        for(int i =0; i<len; i++){
            for(int j =0; j<leny; j++){
                matrix[i][j] += (i-1>=0? matrix[i-1][j]:0);
            }
        }
        
        for(int i =0; i<len; i++){
            for(int j = i; j<len; j++){
                int l = -1; 
                int h = -1;
                int sum = 0;
                while(h<leny){
                    if(sum<target){
                        if(++h<len){
                        	sum+= getSum(matrix,i,j,h);
                        }
                        else break;
                    }
                    else if(sum>target){
                        sum-= getSum(matrix,i,j,++l);
                    }
                    else return true;
                }
            }
        }
        return false;
    }
    
    public static int getSum(int[][] matrix, int i, int j, int k){
        return matrix[j][k] - (i-1>=0 ? matrix[i-1][k] : 0);
    }

}
