package src.sortingProblems;

public class SelectionSort {

    public int[] sort(int[] arr){
        int largestIndex;
        for (int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++){
                if (arr[i] > arr[largestIndex]) largestIndex = i;
            }
            swap(arr, lastUnsortedIndex, largestIndex);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
