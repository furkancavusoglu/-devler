
public class SortInsertionIteratively {
    public static void main(String[] args) {
        //int arr[] = {3, 60, 35, 2, 45, 320, 5};
        //int arr[] = {30, 1, 4, 9, 16, 3, 2};
        int arr[] = {9, 2, 7, 3, 5, 20, 16, 4};

        System.out.println("Array Before Insertion Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        insertionSort(arr);//sorting array elements using bubble sort

        System.out.println("Array After Insertion Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    } /* end-main */


    static void insertionSort(int[] arr) {
        int j, P, tmp;
        int N = arr.length;
        for(P = 1; P < N; P++ ) {
            tmp = arr[ P ];
            for(j = P; j > 0 && arr[ j - 1 ] > tmp; j-- ){
                arr[ j ] = arr[ j - 1 ]; //Shift A[j-1] to right
            } //end-for-inner
            arr[ j ] = tmp; // Found a spot for A[P] (= Tmp)
        } //end-for-outer

    }
}
