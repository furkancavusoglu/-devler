

public class ArraySearchRecursivelyLinear {
    public static void main(String[] args) {
        int[] arr={5,2,3,1,6};
        int number = 7;

        int result = LinearSearch(arr,0,arr.length,number);
        if (result==0)
            System.out.println(number + " is not found in the array ");
        else
            System.out.println(number + " is found in the array ");

    } /* end-main */


    /* Computes 1+2+3+…+n */
    static int LinearSearch(int[] arr, int index, int N, int key) {
    /* Base cases */
        if (N == 0) return 0; /* Unsuccessful search */
        if (key == arr[index]) return 1;   /* Success */

    /* Divide & Conquer & Merge */
        return LinearSearch(arr, index+1, N-1, key);

    } /* end-Sum */
}

