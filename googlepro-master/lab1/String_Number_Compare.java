package lab1;

public class String_Number_Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int compare(char[] arr1, char[] arr2) {
        int index1 = 0, index2 = 0, result = 0, sign = 1;
        boolean isNeg1 = false, isNeg2 = false;
        if(arr1[index1] == '-') isNeg1 = true;
        if(arr2[index1] == '-') isNeg2 = true;
       
        if(!isNeg1 && isNeg2) return 1;
        else if(isNeg1 && !isNeg2) return -1;
        else if(isNeg1 && isNeg2) {
                index1++; index2++;
                sign = -1;
        }
       
        while(index1 < arr1.length && arr1[index1] != '.' && index2 < arr2.length && arr2[index2] != '.') {
                if(result == 0 && arr1[index1] > arr2[index2]) {
                        result = 1;
                } else if(result == 0 && arr1[index1] < arr2[index2]) {
                        result = -1;
                }
                index1++; index2++;
        }
       
        boolean isEnd1 = false, isEnd2 = false;
        if(index1 >= arr1.length || arr1[index1] == '.') isEnd1 = true;
        if(index2 >= arr2.length || arr2[index2] == '.') isEnd2 = true;
       
        if(isEnd1 && !isEnd2) {
                return -1 * sign;
        } else if(!isEnd1 && isEnd2) {
                return 1 * sign;
        } else if(isEnd1 && isEnd2) {
                if(result != 0) return result * sign;

                index1++; index2++;
                char next1 = index1 >= arr1.length ? '0' : arr1[index1];
                char next2 = index2 >= arr2.length ? '0' : arr2[index2];
                while(index1 < arr1.length || index2 < arr2.length) {
                        if(next1 > next2) {
                                return 1 * sign;
                        } else if(next1 < next2) {
                                return -1 * sign;
                        }
                        index1++; index2++;
                        next1 = index1 >= arr1.length ? '0' : arr1[index1];
                        next2 = index2 >= arr2.length ? '0' : arr2[index2];
                }
        }
       
        return 0;
}
}
