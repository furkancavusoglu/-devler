

public class ComputeFibonacciIteratively {
    public static void main(String[] args) {
        int x = 0;

        x = Fibonacci(5);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes nth Fibonacci number */
    static int Fibonacci(int n){
        int result = 0;
        int prev = 0;
        int current = 1;
        int tmp;

        if(n == 1) {
            return 0;
        }

        for(int i=1; i<n; i++) {
            result = prev+current;
            tmp = current;
            current=result;
            prev = tmp;
        }
        return result;
    } /* end-Fibonacci */


}
