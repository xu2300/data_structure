package lab1;

public class Inserted_Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabf", t = "aabfe";
		System.out.println(oneDi(s,t));
	}
	//find the char
	public static char oneDif(String s, String t){
		int lens = s.length(), lent = t.length();
		int i=0, j=0;
		while(i<lens && j<lent){
			if(s.charAt(i) != t.charAt(j)){
				if(j+1<lent && s.charAt(i) == t.charAt(j+1))
					return t.charAt(j);
				else return s.charAt(i);
			}
			else{
				i++;
				j++;
			}
		}
		if(i<lens) return s.charAt(i);
		return t.charAt(j);
	}
	// to determine
	public static boolean oneDi(String s, String t){
		int lens = s.length(), lent = t.length();
		if(Math.abs(lens-lent)!=1) return false;
		int i =0, j=0;
		boolean onedif = true;
		while(i<lens && j<lent){
			if(s.charAt(i) != t.charAt(j)){
				if(onedif){
					onedif = false;
					if(j+1<lent && s.charAt(i) == t.charAt(j+1)){
						j++;
					}
					else if(i+1<lens && t.charAt(j) == s.charAt(i+1)){
						i++;
					}
					else return false;
				}
				else return false;
			}
			else{
				i++;
				j++;
			}
		}
		if(i!=lens || j!=lent){
			if(onedif) return true;
			else return false;
		}
		else return true;
	}
}
