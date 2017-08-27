package wish;

import java.util.Arrays;

/**
 * Created by junweixu on 8/25/17.
 */
public class binary_search {
    public static void main(String[] args) {
        int [] heaters = {1 , 3 , 5};
        int h = -11;
//        System.out.print(heaters[help(heaters,h)]);

        System.out.print(Arrays.binarySearch(heaters, h));

    }

    public static int help(int[]heaters, int h ){
        int l=0;
        int r = heaters.length -1;
        while(l<r){
            int m = l + (r-l)/2;
            if(heaters[m] < h){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }
}
