
public class ArraySearchIterativelyBinary {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11,13,15};
        int number = 7;

        int result = BinarySearch(arr,0,arr.length-1,number);
        if (result==0)
            System.out.println(number + " is not found in the array ");
        else
            System.out.println(number + " is found in the array ");

    } /* end-main */


    static int BinarySearch(int[] arr, int left, int right, int key) {

        while (left<=right) {
            int middle = (left + right) / 2;

            if (key < arr[middle]) {
                right = middle - 1;
            } else if (key > arr[middle]) {
                left = middle + 1;
            } else if (key == arr[middle]) {
                return 1;
            }
        }
        return 0;

    }
}
