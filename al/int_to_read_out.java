package amazon;

public class int_to_read_out {

	public static void main(String[] args) {
		System.out.println(toenglish(999));
	}
	
	public static String toenglish(int n ){
	    
		String[] lessThan20 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

		String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		    
		    if(n<20){
		        return lessThan20[n-1]+ " ";       
		    }
		    else if(n<100){
		        return tens[n/10-2] + " " + toenglish(n%10);
		    }
		    else {
		        return lessThan20[n/100-1] + " "+"Hundrend" + " " + toenglish(n%100);
		    }
	}
}
