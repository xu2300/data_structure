

import java.util.BitSet;

public class detectDuplicateInArray {

	public static void main(String[] args) {
		int[] test = new int[]{0,3,2,1,6,100,100};
		System.out.println(hasDuplicate(test));

	}

	public static boolean hasDuplicate(int[] arr){
		BitSet b = new  BitSet();
		int check = 0;
		int len = arr.length;
		for(int i=0; i<len; i++){
			if(b.get(arr[i])) return true;
			else b.set(arr[i]);
		}
		return false;
	}

}
