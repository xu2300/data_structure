package simple_question;

public class String_Rotation {
	public static final int SIZE=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="waterbottle";
		String str2="bottlewatre";
		boolean bool=checkRotation(str1,str2);
		System.out.println(bool);

	}
	
	//we used trick here: if x is rotation of y, then x=ab and y=ba; x+x=abab, to check the rotation 
	//then y is substring of x+x
	//time:O(1)
	public static boolean checkRotation(String str1, String str2){
		if(str1.length()==str2.length()&& str1.length()>0){
		String s=str1+str1;
		if(s.contains(str2))
			return true;
		}
		return false;
	}
}
