package lab1;

import java.util.*;

/**
 * Created by junweixu on 8/24/17.
 */
public class find_k
{
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0,1,1,1,2,3,6,7,8,9));
        for(int i : findClosestElements(arr,9,4))
        System.out.print(i);
    }

    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int len = arr.size();
        int l = 0, r = len-1;
        while(l<r){
            int m = l + (r-l)/2;
            if(arr.get(m) < x){
                l = m+1;
            }else{
                r = m;
            }
        }

        r = l;
        l = l-1;
        while(k!=0){
            if(l<0){
                r++;
            }else if(r>len-1){
                l--;
            }else if(Math.abs(arr.get(r)-x) >=  Math.abs(arr.get(l)-x)){
                r++;
            }else{
                l--;
            }
            k--;
        }
        return arr.subList(l+1, r);
    }
}
