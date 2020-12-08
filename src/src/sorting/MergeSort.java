package src.sorting;

public class MergeSort {

    public int[] sort(int[] array){
        mergeSort(array, 0, array.length);
        return array;
    }

    private void mergeSort(int[] array, int start, int end){
        if(start > end - 2) return ;

        int mid = (start + end) / 2  ;

        mergeSort(array, start, mid);
        mergeSort(array, mid, end);

        merge(array, start, mid, end);

    }

    private void merge(int[] array, int start, int mid, int end){

        int i = start;
        int j = mid;
        int[] tmp = new int [end - start];
        int newIndex = 0;

        while (i < mid && j < end){

            tmp[newIndex++] = array[i] < array[j] ? array[i++] : array[j++];

        }

        while (i < mid) {
            tmp[newIndex++] = array[i++];
        }

        while (j < end){
            tmp[newIndex++] = array[j++];
        }

        System.arraycopy(tmp, 0, array, start, newIndex);

    }
}
