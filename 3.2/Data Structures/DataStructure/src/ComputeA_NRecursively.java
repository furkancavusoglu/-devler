

public class ComputeA_NRecursively {

    public static void main(String[] args) {
        double x = 0;

        x = Power(3,4);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes a^n */
    static double Power(double a, int n){
  /* Base cases */
        if (n == 0) return 1;
        else if (n == 1) return a;

        return Power(a, n-1)*a;
    } /* end-Power */



}
