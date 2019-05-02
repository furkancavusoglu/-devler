

public class ComputeFibonacciRecursively {

    public static void main(String[] args) {
        int x = 0;

        x = Fibonacci(5);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes nth Fibonacci number */
    static int Fibonacci(int n){
  /* Base cases */
        if (n == 0) return 0;
        if (n == 1) return 1;

        return Fibonacci(n-1) + Fibonacci(n-2);
    } /* end-Fibonacci */



}