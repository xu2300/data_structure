package pointer;

import java.io.*;
import java.util.*;
class CountTriangles
{
    static int findNumberOfTriangles(int arr[])
    {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n-2; ++i)
        {
        	int k = i+2;
            for (int j = i+1; j < n; ++j)
            {	
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;
                count += k - j - 1;
            }
        }
        return count;
    }
 
    public static void main (String[] args)
    {
        int arr[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Total number of triangles is " +
                            findNumberOfTriangles(arr));
    }
    
    static int[] findOnePairOfTriangles(int arr[]){
    	int n = arr.length;
    	int [] re=  new int [3];
    	Arrays.sort(arr);
    	for(int i=0; i+2<n; i++){
    		if(arr[i]+arr[i+1]>arr[i+2]){
    			re[0] = i;
    			re[1] = i+1;
    			re[2] = i+2;
    			return re;
    		}
    	}
    	return re;
    }
    
    
    
   // O(n^3) to find all triangles
    public static List<List<Integer>> findTriangles(int[] edges) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (edges == null || edges.length < 3) {
            return result;
        }
        Arrays.sort(edges);
        int len = edges.length;
        for (int i = 0; i <= len - 3; ++i) {
            if (i != 0 && edges[i] == edges[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= len - 2; ++j) {
                if (j != i + 1 && edges[j] == edges[j - 1]) {
                    continue;
                }
                int sum = edges[i] + edges[j];
                for (int k = j + 1; k <= len - 1; ++k) {
                    if (k != j + 1 && edges[k] == edges[k - 1]) {
                        continue;
                    }
                    if (sum <= edges[k]) {
                        break;
                    }
                    List<Integer> triangle = new ArrayList<Integer>();
                    triangle.add(edges[i]);
                    triangle.add(edges[j]);
                    triangle.add(edges[k]);
                    result.add(triangle);
                }
            }
        }
        return result;
    }
    
    //no duplicates
    public class Triangle {
        public List<List<Integer>> validTriangle(int[] edges) {
            List<List<Integer>> result = new ArrayList<>();
            if (edges == null || edges.length < 3) {
                return result;
            }
             
            Arrays.sort(edges);
             
            for (int i = 0; i < edges.length - 2; i++) {
                for (int j = i + 1; j < edges.length - 1; j++) {
                    for (int k = j + 1; k < edges.length; k++) {
                        if (edges[i] + edges[j] > edges[k]) {
                            List<Integer> curr = new ArrayList<>();
                            curr.add(edges[i]);
                            curr.add(edges[j]);
                            curr.add(edges[k]);
                            result.add(curr);
                        }
                    }
                }
            }
             
            return result;
        }
    }
    
    
    
    public boolean existTriangle(int[] edges) {
        if (edges == null || edges.length < 3) {
            return false;
        }
        Arrays.sort(edges);
        int len = edges.length;
        for (int i = 0; i <= len - 3; ++i) {
            if (i != 0 && edges[i] == edges[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= len - 2; ++j) {
                if (j != i + 1 && edges[j] == edges[j - 1]) {
                    continue;
                }
                int sum = edges[i] + edges[j];
                if (sum > edges[j + 1]) {
                    return true;
                } 
            }
        }
        return false;
    }

}