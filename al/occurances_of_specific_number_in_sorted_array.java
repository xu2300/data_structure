

public class occurances_of_specific_number_in_sorted_array {
//occurance times of specific number
	public static void main(String[] args) {
		int [] num = {1,1,1,2,2,2,4,4,4,5};
		System.out.print(occ(num,2));
	}
	
	public static int occ(int [] num, int target){
		int n = num.length;
		int l = 0;int h = n-1;
		while(l<h){
			int m = (l+h)/2;
			if((m==0 && num[m]==target) || (num[m-1]!=target && num[m] == target)){
				l = m;
				break;
			}
			else if(num[m]>=target) h =m-1;
			else if(num[m] < target) l = m+1;
		}
		
		
		int l1 = 0;
		int h1 = n-1;
		while(l1<h1){
			int m = (l1+h1)/2;
			if((m==n-1 && num[m]==target) || (num[m+1]!=target && num[m] == target)){
					l1 = m;
					break;
			}
			else if(num[m]<=target) l1 =m+1;
			else if(num[m] > target) h1 = m-1;
		}
		return l1 - l +1;
	}

}
