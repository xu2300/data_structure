package matrix;

public class diagonosed__true {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [][]m = {{1,3,4,5},
						 {7,1,3,4},
						 {7,7,1,3}};
			System.out.print(printDiagonally(m));
	}
	
	public static boolean printDiagonally(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0)
            return true;
        int rows = m.length, columns = m[0].length;
        
        for (int j = columns - 1; j >= 0; j--) {
            int start = Integer.MIN_VALUE;
        	for (int i = 0; i < rows; i++){
                if (j + i < columns){
                	if(start==Integer.MIN_VALUE){
                		start = m[i][i+j];
                	}
                	else{
                		if(m[i][i+j]!=start) return false;
                	}
                }
        	}       
        }
        
        for (int i = 1; i < rows; i++) {
        	int start = Integer.MIN_VALUE;
        	for (int j = 0; j < columns; j++){
                if (i + j < rows){
                	if(start==Integer.MIN_VALUE){
                		start = m[i+j][j];
                	}
                	else{
                		if(m[i+j][j]!=start) return false;
                	}
                }
        	}       
        }
        return true;
    }
}
