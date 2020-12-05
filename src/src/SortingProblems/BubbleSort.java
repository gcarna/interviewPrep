package src.SortingProblems;

public class BubbleSort {

    public int[] sort(int[] array) {
        for (int i=array.length-1; i > 0; i--){
            for (int j=0; j<i; j++){
                if(array[j]>array[j+1]){
                   swap(array, j, j+1);
                }
            }
        }
        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
