

public class ArraySumRecursivelyExample2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int x = 0;

        x = Sum(arr,0,arr.length);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes 1+2+3+…+n */
    static int Sum(int[] arr, int index1, int index2) {
            /* Base case */
        if (index2-index1 == 1) return arr[index1];

    /* Divide & Conquer */
        int middle = (index1+index2)/2;
        int localSum1 = Sum(arr, index1, middle);
        int localSum2 = Sum(arr, middle, index2);

    /* Merge */
        return localSum1 + localSum2;
    } /* end-Sum */
}
