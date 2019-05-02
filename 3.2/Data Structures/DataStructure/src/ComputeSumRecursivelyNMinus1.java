

public class ComputeSumRecursivelyNMinus1 {

    public static void main(String[] args) {
        int x = 0;

        x = Sum(4);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes 1+2+3+…+n */
    static int Sum(int n) {
        int partialSum = 0;

  /* Base case */
        if (n == 1) return 1;

  /* Divide and conquer */
        partialSum = Sum(n - 1);

  /* Merge */
        return partialSum + n;
    } /* end-Sum */


}
