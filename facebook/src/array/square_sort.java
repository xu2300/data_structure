
public class square_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] r = {-3, -1, 0, 1, 2};
		int[] m = sort(r);
		for(int i : m)
		System.out.print(i);
	}
	
	public static int[] sort(int [] arr){
		int [] re= new int [arr.length];
		int count = re.length-1;
		int l = 0; 
		int r = arr.length-1;
		while(l<=r){
			if(Math.abs(arr[r])>=Math.abs(arr[l])){
				re[count--] = arr[r]*arr[r];
				r--;
			}
			else{
				re[count--] = arr[l]*arr[l];
				l++;
			}
		}
		return re;
	}
}
