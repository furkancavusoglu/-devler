

public class ComputeSumIteratively {

    public static void main(String[] args) {
        int x = 0;

        x = Sum(4);
        System.out.println("x: " + x);

    } /* end-main */


    /* Computes 1+2+3+…+n */
    static int Sum(int n) {
        int sum = 0;
        int i;

        for (i=1; i<=n; i++)
            sum += i;
        return sum;
    } /* end-Sum */


}
