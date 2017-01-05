package goo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class k_nearest_point {

	public static void main(String[] args)  {
		addPoint(new Point(1,1));
		addPoint(new Point(0,3));
		addPoint(new Point(0,4));
		addPoint(new Point(0,5));
		addPoint(new Point(0,6));
		addPoint(new Point(0,7));
		for(Point s : findNearest(new Point(0,0), 3)){
			System.out.println(s.x +" " + s.y);
		}
		
	}
	
	private static List<Point> re=  new ArrayList<Point>();
	
	public static void addPoint(Point point){
	    	re.add(point);
	}
	    
	    
	 public static List<Point> findNearest(Point center, int p){
		    
	    	Comparator<Point> m = new Comparator<Point>(){
	    		public int compare(Point a, Point b){
	    			return Double.compare(getDistance(b,center) ,getDistance(a,center));
	    		}
	    	};
		    
	    	List<Point> r=  new ArrayList<Point>();
	    	PriorityQueue<Point> pq = new PriorityQueue<Point>(p, m);
	    	for(int i =0; i<re.size(); i++){
	    		pq.offer(re.get(i));
	    		if(pq.size() >p){
	    			pq.poll();
	    		}
	    	}
	    	while(!pq.isEmpty()){
	    		r.add(pq.poll());
	    	}
	    	Collections.sort(r,m);
	    	return r;
	 }
	    
	    private static double getDistance(Point a, Point b) {
	        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	    }
	    
	    public static class Point {
	        final int x;
	        final int y;

	        public Point(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }
	    
	    
}




/*

//quick select
public static class Point {
    public double x;
    public double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
}

public static double kthSmallest(final double[] A, final int p, final int r, final int k) {
    if (p < r) {
        final int q = RandomizedPartition(A, p, r);

        final int n = q - p + 1;
        if (k == n) {
            return A[q];
        } else if (k < n) {
            return kthSmallest(A, p, q - 1, k);
        } else {
            return kthSmallest(A, q + 1, r, k - n);
        }
    } else {
        return Double.MIN_VALUE;
    }
}

public static Point[] closestkWithOrderStatistics(final Point points[], final int k) {
    final int n = points.length;
    final double[] dist = new double[n];
    for (int i = 0; i < n; i++) {
        dist[i] = Math.sqrt(points[i].x * points[i].x + points[i].y * points[i].y);
    }
    final double kthMin = kthSmallest(dist, 0, n - 1, k);

    final Point[] result = new Point[k];
    for (int i = 0, j = 0; i < n && j < k; i++) {
        final double d = Math.sqrt(points[i].x * points[i].x + points[i].y * points[i].y);
        if (d <= kthMin) {
            result[j++] = points[i];
        }
    }

    return result;
}

private static void swap(final double input[], final int i, final int j) {
    final double temp = input[i];
    input[i] = input[j];
    input[j] = temp;
}

private static int partition(final double[] A, final int p, final int r) {
    final double pivot = A[r];
    int i = p - 1;
    int j = p;

    for (j = p; j < r; j++) {
        if (A[j] <= pivot) {
            swap(A, ++i, j);
        }
    }

    swap(A, i + 1, r);
    return i + 1;
}

private static int RandomizedPartition(final double[] A, final int p, final int r) {
    final int i = (int) Math.round(p + Math.random() * (r - p));
    swap(A, i, r);
    return partition(A, p, r);
}
*/