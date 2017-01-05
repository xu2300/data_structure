package lab1;

public class move_array_k_digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [] a = {1, 2, 3, 4,5,6,7};
			int k = 2;
			exchange(a,2);
			for(int i : a )
			System.out.print(i + "  ");
	}
	
	public static void exchange(int [] re, int k){
		int len = re.length;
		int gcd = gcd(len,k);
		for(int i =0; i<gcd; i++){
			int orindex = i;
			int start = i;
			int orivalue = re[i];
			int temp = 0;
			while(true){
				int j = orindex+k;
				if(j >=len)
					j = j%len;
				temp = re[j];
				re[j] = orivalue;
				orindex = j;
				orivalue = temp;
				if(j == start) break;
			}
		}
		return;
	}
	
	public static int gcd(int a, int b){
		int temp = b;
		while(b!=0){
			temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	
}
