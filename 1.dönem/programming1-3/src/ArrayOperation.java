public class ArrayOperation {

    public int secondLargestElementsOfanArray(int[] myarray) {
        //return second largest elements of the method parameter myarray
        int first = myarray[0];
        int second = 0;
        for (int i = 1; i < myarray.length; i++) {
            if (first < myarray[i]) {
                second = first;
                first = myarray[i];
            }
            if (second < myarray[i] && first > myarray[i])
                second = myarray[i];
        }
        return second;
    }

    public int numberOfevenNumbers(int[] myarray) {
        int numOfEvens = 0;
        for (int element : myarray) {
            if (element % 2 == 0)
                numOfEvens++;
        }

        return numOfEvens;
    }

    public int theMostRepeatedElement(int[] myarray) {
        int recurrence;
        int number = -1;
        int realRecurrence = 0;
        for (int i = 0; i < myarray.length; i++) {
            recurrence = 0;
            number = myarray[i];
            for (int j = 0; j < myarray.length; j++) {
                if (myarray[i] == myarray[j]) {
                    recurrence++;
                }
            }
            if (recurrence > realRecurrence) {
                realRecurrence = recurrence;
                number = myarray[i];
            }
        }
        return number;
    }

    public static int numberOfElementsInUnionOfTwoArray(int[] array1, int[] array2) {
        //find the number of elements in the union of the method parameter array1 and array2
        //if array1={1,3,2,5,9,6} and array2={4,6,8,1,3,2} then the union is {1,2,3,4,5,6,8,9}
        //since there are 8 elements in the union, return 8.
        //if there is no element in the union return 0.
        int unique = 0;
        int[] union = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, union, 0, array1.length);
        System.arraycopy(array2, 0, union, array1.length, array2.length);
        for (int i = 0; i < union.length; i++) {
            boolean isMatched = false;
            for (int j = 0; j < i; j++) {
                if (union[i] == union[j]) {
                    isMatched = true;
                    break;
                }
            }
            if (!isMatched) {
                unique++;
            }
        }
        return unique;
    }
}
