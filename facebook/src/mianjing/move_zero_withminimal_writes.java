
public class move_zero_withminimal_writes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1};
		help(arr);
		for(int i:arr)
		System.out.print(i);
	}
	
	public static void help(int arr[]){
		int l = 0;
		int r = arr.length-1;
		while(l<r){
			if(arr[l]!=0){
				l++;
				continue;
			}
			if(arr[r]==0){
				r--;
				continue;
			}
			arr[l++] = arr[r--];
		}
		return ;
	}
}
