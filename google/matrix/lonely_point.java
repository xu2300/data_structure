package matrix;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lonely_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]a = {{1,0,0,0},
					{0,1,0,0},
					{0,1,0,0},
					{0,0,1,0},};
		for(Point p: help(a)){
			System.out.println(p.x+" "+p.y);
		}
	}
	
	public static List<Point> help (int[][] a){
		List<Point> re = new ArrayList<Point>();
		int m = a.length;
		int n = a[0].length;
		int [] row = new int [m];
		Arrays.fill(row, -1);
		int [] col = new int [n];
		Arrays.fill(col, -1);
		for(int i =0; i<m; i++){
			for(int j =0; j<n; j++){
				if(a[i][j] ==1){
					if(row[i] == -1)
						row[i] = j;
					else if(row[i] >=0) 
						row[i] = -2;
						
					if(col[j] == -1)
						col[j] = i;
					else if(col[j] >=0) 
						col[j] = -2;
				}
			}
		}
		for(int i=0; i<m; i++){
			if(row[i]>=0 && col[row[i]] == i){
				re.add(new Point(i,row[i]));
			}
		}
		return re;
	}

}
