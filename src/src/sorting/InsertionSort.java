package src.sorting;

public class InsertionSort {
    private static int[] sort(int[] array, int gap) {
        for (int firstUnsortedIndex = gap; firstUnsortedIndex < array.length; firstUnsortedIndex++){
            int newElement = array[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i-gap >= 0 && newElement < array[i-gap]; i=i-gap){
                    array[i] = array[i - gap];
            }
            array[i] = newElement;
        }
        return array;
    }

    private static void recursiveSort(int[] array, int numElements){
        if (numElements < 2) return ;

        recursiveSort(array, numElements - 1);

        int newElement = array[numElements - 1];
        int i;
        for (i = numElements - 1; i > 0 && newElement < array[i-1]; i=i-1){
            array[i] = array[i - 1];
        }
        array[i] = newElement;

    }

//   {20,35,-15,7,55,1,-22};

    public static int[] shellSort(int[] array) {
        for(int i = array.length/2; i > 0; i = i/2){
            array = sort(array, i);
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {

         recursiveSort(array, array.length);

         return array;
    }


}
