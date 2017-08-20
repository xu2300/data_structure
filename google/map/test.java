package map;

/**
 * Created by junweixu on 8/6/17.
 */
public class test {
    public static void main(String[] args) {
        int arr1[] = {1, 4,19};
        int arr2[] = {2,6,5};
        System.out.print(getMedian(arr1,arr2));

    }

    public static int getMedian(int arr1[], int arr2[]){
        int n = arr1.length;
        if(n==1) return (arr1[0]+arr2[0])/2;
        return help(arr1, 0, n-1, arr2, 0, n-1);
    }

    public static int help(int arr1[],int l1 ,int h1 , int arr2[], int l2, int h2){
        int mid1 = (h1 + l1 ) / 2;
        int mid2 = (h2 + l2 ) / 2;

        if(h1-l1 == 1){
            return (Math.max(arr1[l1],arr2[l2]) + Math.min(arr1[h1],arr2[h2]))/2;
        }
        if(arr1[mid1]<arr2[mid2]){
            return help(arr1, mid1, h1, arr2, l2,mid2);
        }else{
            return help(arr1, l1, mid1, arr2, mid2,h2);
        }
    }
}
