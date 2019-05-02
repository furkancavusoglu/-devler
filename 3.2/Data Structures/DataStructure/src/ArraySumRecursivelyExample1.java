

public class ArraySumRecursivelyExample1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int x = 0;

        x = Sum(arr,0,arr.length);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes 1+2+3+…+n */
    static int Sum(int[] arr, int start, int N) {
	/* Base case */
        if (N == 1) return arr[start];

	/* Divide & Conquer */
        int localSum = Sum(arr, start + 1, N - 1);

	/* Merge */
        return arr[start] + localSum;

    } /* end-Sum */
}
