
public class index_where_any_permutation_of_b_is_a_substring_of_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(strstp("hellwo", "ow"));
	}
	
	 public static int strstp(String s, String t) {
		 int[] map = new int[256];
		 int count =0;
		 for(char m : t.toCharArray()){
			 map[m]++;
			 count ++;
		 }
		 int tlen = t.length();
		 int slen = s.length();
		 int st = 0, en = 0;
		 while(en<slen){
			 if(--map[s.charAt(en++)] >=0){
				 count--;
			 }
			 if(en<tlen) continue;
			 if(count == 0) return st;
			 if(map[s.charAt(st++)]++ >=0){
				 count ++;
			 }
		 }
		 return -1;
	 }
}
