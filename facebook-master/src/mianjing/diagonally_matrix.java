
public class diagonally_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [][]m = {{1,2,3,5},
						 {4,5,6,4},
						 {2,7,3,4}};
			printDiagonally(m);
	}
	
	public static void printDiagonally(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0)
            return;
        int rows = m.length, columns = m[0].length;

        for (int j = columns - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++)
                if (j + i < columns)
                    System.out.print(m[i][i + j] + " ");
            System.out.println();
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                if (i + j < rows)
                    System.out.print(m[i + j][j] + " ");
            System.out.println();
        }
    }
}
