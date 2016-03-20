
 public class search_Increasing_DecreasingArray{
	public static void main(String[] args){
		int[] arr = new int[] {1,2,3,19,34,555,444,22,3}; 
		System.out.println(search(arr, 22));

	}


	public static int search(int[] arr, int target){
		int peak = findPeak(arr, 0, arr.length-1);

		System.out.println("Peak element index: " + peak);

		int res = binarySearch(arr, 0, peak, target);

		if(res != -1){
			return res;
		}else{
			return binarySearch(arr, peak+1, arr.length-1, target);
		}

	}

    public static int findPeak(int[] arr, int l, int h){
    		while(l<h-1){
    			int m = (l+h)/2;
    			if(arr[m]>arr[m-1] && arr[m]>arr[m+1]) return m;
    			if(arr[m]<arr[m-1] && arr[m]>arr[m+1]) h=m;
    			if(arr[m]>arr[m-1] && arr[m]<arr[m+1]) l=m;
    		}
    		if(arr[l]>arr[h]) return l;
    		else return h;
    }
    
    public static int binarySearch(int[] arr, int l, int h,int target){
    		while(l<h){
    			int m =(l+h)/2;
    			if(arr[m]== target) return m;
    			else if(arr[m]>target) h=m-1;
    			else l= m+1;
    		}
    		return l;
    }
 }	