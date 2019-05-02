

public class ArraySearchRecursivelyBinary {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11,13,15};
        int number = 6;

        int result = BinarySearch(arr,0,arr.length,number);
        if (result==0)
            System.out.println(number + " is not found in the array ");
        else
            System.out.println(number + " is found in the array ");

    } /* end-main */


    static int BinarySearch(int[] arr, int index1, int index2, int key) {
        int middle = (index1+index2)/2;
        int N = index2-index1;

    /* Base cases */
        if (key == arr[middle]) return 1; /* Success */
        if (N == 1) return 0; /* Unsuccessful search */

    /* Conquer & Merge */
        else if (key < arr[middle])
            return BinarySearch(arr, index1, middle, key);
        else
            return BinarySearch(arr, middle, index2, key);

    }
}
