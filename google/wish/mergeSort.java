package wish;

/**
 * Created by junweixu on 8/25/17.
 */
public class mergeSort {
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        mergeSort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }


    public static void mergeSort(int[]arr, int l, int r){
        if(l<r){
            int m = l + (r-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    public static void merge(int[]arr, int l, int m, int r){
        int len1 = m-l+1;
        int len2 = r-m;

        int [] L = new int [len1];
        int [] R = new int [len2];

        for(int i=0; i<len1; i++){
            L[i] = arr[l+i];
        }
        for(int i=0; i<len2; i++){
            R[i] = arr[m+1+i];
        }

        int i=0, j=0;
        int k = l;
        while(i<len1 && j<len2){
            if(L[i] <= R[j]){
                arr[k++] = L[i++];
            }else {
                arr[k++] = R[j++];
            }
        }

        while(i < len1){
            arr[k++] = L[i++];
        }
        while(j < len2){
            arr[k++] = R[j++];
        }
    }
}
