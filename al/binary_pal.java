
public class binary_pal {

	public static void main(String[] args) {
		System.out.print(pal(98304));

	}
	
	public static boolean pal(int n){
		 int r = 0;
		 int m = n;
	        for(int i =0;i<32;i++){
	        		r = (r<<1);
	            r+= (n&1);
	            n= n>>>1;
	        }
	        if(r == m) return true;
	        else return false;
	}

}
