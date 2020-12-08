package main.java.sorting;

public class QuickSort {

//    private static void quickSort(int[] array,  int start, int end){
//        if(end > start ) return;
//
//        int pivot = partition(array, start, end);
//
//
//
//    }
//
//    public static int[] sort(int[] array){
//
//
//        for (int i=0; i < array.length; i++){
//            quickSort(array, array[i], 0, array.length-1);
//        }
//
//        return array;
//    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
