
public class ArraySearchIterativelyLinear {
    public static void main(String[] args) {
        int[] arr={5,2,3,1,6};
        int number = 7;

        int result = LinearSearch(arr,0,arr.length,number);
        if (result==0)
            System.out.println(number + " is not found in the array ");
        else
            System.out.println(number + " is found in the array ");

    } /* end-main */


    static int LinearSearch(int[] arr, int startIndex, int N, int key) {
    /* Base cases */
        for(int i=startIndex;i<N;i++){
            if (arr[i]==key)
                return 1;
        }
        return 0;

    }
}
