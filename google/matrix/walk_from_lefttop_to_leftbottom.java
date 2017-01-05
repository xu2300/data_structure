package matrix;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
public class walk_from_lefttop_to_leftbottom {
	/*第一轮，一个m*n的matrix , 从左上到左下有多少种走法。用dp
	follow up 1 : 有一个点(x,y)必须要经过，有多少走法。然后优化内存，用rolling array. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
	follow up 2 : 有一个set的点都要经过，有多少走法。我说要用HashSet来快速找点，然后问Point class怎么做hashing，写了hashCode function
	//matrix中每一步有要求，必须要向下走，同时水平方向上每次有（-1,0,1）三个选择*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = new int[10][12];
		Set<Point> p = new HashSet<Point>();
		p.add(new Point(9,1));
		System.out.println(walk1(a,p));
		int [][] b = new int[2][12];
		System.out.println(walk2(b,10,12,9,1));
		int [][] c = new int[10][12];
		System.out.println(walk(c,9,1));
	}
	//the ways from from_lefttop_to_leftbottom 
	public static int walk1(int [][] a, Set<Point> s){
		int m  = a.length;
		int n = a[0].length;
		a[0][0] = 1;
		for(int i=1; i<m-1; i++){
			for(int j =0; j<n ;j++){
				if(j-1>=0)
					a[i][j] += a[i-1][j-1];
				if(j+1<n)
					a[i][j] += a[i-1][j+1];
				a[i][j] += a[i-1][j];
				if(s.contains(new Point(i,j))){
					for(int jj =0; jj<n ; jj++){
						if(jj!=j) a[i][jj] = 0;
					}
					j = n;
				}
			}
		}
		a[m-1][0] += a[m-2][0];
		a[m-1][0] += a[m-2][1];
		return a[m-1][0];
	}
	
	public static int walk(int [][] a, int x , int y){
		int m  = a.length;
		int n = a[0].length;
		a[0][0] = 1;
		for(int i=1; i<m-1; i++){
			for(int j =0; j<n ;j++){
				if(i == x && j!=y){
					a[i][j] = 0;
					continue;
				}
				if(j-1>=0)
					a[i][j] += a[i-1][j-1];
				if(j+1<n)
					a[i][j] += a[i-1][j+1];
				a[i][j] += a[i-1][j];
				if(i == x&& j == y) break;
			}
		}
		a[m-1][0] += a[m-2][0];
		a[m-1][0] += a[m-2][1];
		return a[m-1][0];
	}
	
	public static int walk2(int [][] a, int m, int n, int x , int y){
		a[0][0] = 1;
		for(int i=1; i<m-1; i++){
			for(int j =0; j<n ;j++){
				if(i == x && j!=y){
					a[i%2][j] = 0;
					continue;
				}
				a[i%2][j] = 0;
				if(j-1>=0)
					a[i%2][j] += a[(i-1)%2][j-1];
				if(j+1<n)
					a[i%2][j] += a[(i-1)%2][j+1];
				a[i%2][j] += a[(i-1)%2][j];
				if(i == x&& j == y) break;
			}
		}
		a[(m-1)%2][0] = a[(m-2)%2][0];
		a[(m-1)%2][0] += a[(m-2)%2][1];
		return a[(m-1)%2][0];
	}

}
