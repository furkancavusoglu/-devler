
public class SortSelectionIteratively {
    public static void main(String[] args) {
        //int arr[] = {3, 60, 35, 2, 45, 320, 5};
        //int arr[] = {30, 1, 4, 9, 16, 3, 2};
        int arr[] = {9, 2, 7, 3, 5, 20, 16, 4};

        System.out.println("Array Before Selection Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        selectionSort(arr);//sorting array elements using bubble sort

        System.out.println("Array After Selection Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    } /* end-main */


    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}
