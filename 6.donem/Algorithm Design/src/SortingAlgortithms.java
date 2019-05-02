import java.util.*;

public class SortingAlgortithms {

/*  implement sorting algorithms below
•	Bubble Sort
•	Selection Sort
•	Insertion Sort
•	Merge Sort
•	Quick Sort
•	Heap Sort
•	Counting Sort
•	Radix Sort

   Fill in the method.
   Implement sorting algorithms.
   You can use extra method.

*/
    private long bubble,selection,insertion,merge,quick,heap,counting,radix;
    private long start,end;



    public void BubbleSort(int A[]) {
        start = System.currentTimeMillis();
        int temp;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A.length - i - 1); j++) {
                if (A[j] > A[j + 1]) {
                    temp = A[j];             // swap
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        end = System.currentTimeMillis();
        bubble = end - start;
    }

    public void SelectionSort(int A[]) {
        start = System.currentTimeMillis();
        int index;
        for (int i = 0; i < A.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[index]) {  //finding small index
                    index = j;
                }
            }
            int smallNumber = A[index];  //swapping
            A[index] = A[i];
            A[i] = smallNumber;
        }
        end = System.currentTimeMillis();
        selection = end - start;
    }

    public void InsertionSort(int A[]) {
        start = System.currentTimeMillis();
        int key;
        int i;
        for (int j = 1; j < A.length; ++j) {
            key = A[j];
            i = j - 1;
            while ((i >= 0) && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
        end = System.currentTimeMillis();
        insertion = end - start;
    }

    public void MergeSort(int A[]) {
        start = System.currentTimeMillis();
        class innerClass {   //inner class for merge method
            void merge(int[] arr, int beg, int mid, int end) {
                int l = mid - beg + 1;
                int r = end - mid;

                int[] LeftArray = new int[l];
                int[] RightArray = new int[r];

                for (int i = 0; i < l; ++i)
                    LeftArray[i] = arr[beg + i];
                for (int j = 0; j < r; ++j)
                    RightArray[j] = arr[mid + 1 + j];

                int i = 0, j = 0;
                int k = beg;
                while (i < l && j < r) {
                    if (LeftArray[i] <= RightArray[j]) {
                        arr[k] = LeftArray[i];
                        i++;
                    } else {
                        arr[k] = RightArray[j];
                        j++;
                    }
                    k++;
                }
                while (i < l) {
                    arr[k] = LeftArray[i];
                    i++;
                    k++;
                }
                while (j < r) {
                    arr[k] = RightArray[j];
                    j++;
                    k++;
                }
            }
            private void sort(int[] arr, int beg, int end) {
                if (beg < end) {
                    int mid = (beg + end) / 2;
                    sort(arr, beg, mid);
                    sort(arr, mid + 1, end);
                    merge(arr, beg, mid, end);
                }
            }
        }
        // creating inner class instance and sorting
        innerClass inner = new innerClass();
        inner.sort(A,0,A.length-1);
        end = System.currentTimeMillis();
        merge = end - start;
    }

    public void QuickSort(int A[]) {
        start = System.currentTimeMillis();
        int l = 0;
        int h = A.length - 1;
        int[] stack = new int[h - l + 1];
        int top = -1;
        stack[++top] = l;
        stack[++top] = h;

        // Popping elements
        while (top >= 0) {
            // Pop hi and l
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            class innerClass {
                private int partition(int[] arr, int low, int high) {
                    int pivot = arr[high];
                    // index of smaller element
                    int i = (low - 1);
                    for (int j = low; j <= high - 1; j++) {
                        if (arr[j] <= pivot) {
                            i++;
                            // swap arr[i] and arr[j]
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                    // swap arr[i+1] and arr[high] (or pivot)
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[high];
                    arr[high] = temp;
                    return i + 1;
                }
            }
            //creating inner class instance
            innerClass inner = new innerClass();
            int partition = inner.partition(A, l, h);
            if (partition - 1 > l) {
                stack[++top] = l;
                stack[++top] = partition - 1;
            }
            if (partition + 1 < h) {
                stack[++top] = partition + 1;
                stack[++top] = h;
            }
        }
        end = System.currentTimeMillis();
        quick= end - start;
    }

    public void HeapSort(int A[]) {
        start = System.currentTimeMillis();
        class innerClass {
            // To heapify a subtree with node i
            private void heapify(int[] arrA, int heapSize, int i) {
                int largest = i; // Initialize largest as root
                int leftChildIdx = 2 * i + 1; // left = 2*i + 1
                int rightChildIdx = 2 * i + 2; // right = 2*i + 2

                // If left child is larger than root
                if (leftChildIdx < heapSize && arrA[leftChildIdx] > arrA[largest])
                    largest = leftChildIdx;

                // If right child is larger than largest so far
                if (rightChildIdx < heapSize && arrA[rightChildIdx] > arrA[largest])
                    largest = rightChildIdx;

                // If largest is not root
                if (largest != i) {
                    int swap = arrA[i];
                    arrA[i] = arrA[largest];
                    arrA[largest] = swap;

                    // Recursive call to  heapify the sub-tree
                    heapify(arrA, heapSize, largest);
                }
            }
        }
        int size = A.length;
        innerClass inner = new innerClass();
        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--)
            inner.heapify(A, size, i);

        // One by one extract (Max) an element from heap and
        // replace it with the last element in the array
        for (int i = size - 1; i >= 0; i--) {

            //arrA[0] is a root of the heap and is the max element in heap
            int x = A[0];
            A[0] = A[i];
            A[i] = x;

            // call max heapify on the reduced heap
            inner.heapify(A, i, 0);
        }
        end = System.currentTimeMillis();
        heap = end - start;
    }

    public void CountingSort(int A[]) {
        start = System.currentTimeMillis();
        int[] c = new int[A.length];
        for (int i: A)
            c[i]++;
        for (int i = 1; i < A.length; i++)
            c[i] += c[i - 1];
        int[] b = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--)
            b[--c[A[i]]] = A[i];
        System.arraycopy(b, 0, A, 0, A.length); //copying array b to array "A"
        end = System.currentTimeMillis();
        counting = end - start;
    }


    public void RadixSort(int A[]) {
        start = System.currentTimeMillis();
        int i, m = A[0], exp = 1, n = A.length;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (A[i] > m)
                m = A[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[100000];

            for (i = 0; i < n; i++)
                bucket[(A[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(A[i] / exp) % 10]] = A[i];
            for (i = 0; i < n; i++)
                A[i] = b[i];
            exp *= 10;
            end = System.currentTimeMillis();
            radix = end - start;
        }
    }

    public void summaryofSortingAlgorithms() {
        System.out.println("*****Summary of Sorting Algorithms*****");
        System.out.println("Using Bubble Sort It took->"+bubble +" milliseconds\n" +
                "    Using Selection Sort It took->"+ selection+" milliseconds\n" +
                "    Using Insertion Sort It took->"+insertion+" milliseconds\n" +
                "    Using Merge Sort It took->"+merge+" milliseconds\n" +
                "    Using Quick Sort It took->"+quick+" milliseconds\n" +
                "    Using Heap Sort It took->"+heap+" milliseconds\n" +
                "    Using Counting Sort It took->"+counting+" milliseconds\n" +
                "    Using Radix Sort It took->"+radix+" milliseconds");
    }
}