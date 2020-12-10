package main.java.sorting;

public class CountingSort {

    static public int[] sort (int[] arr, int k){

        int[] count = new int[k];

        for(int num : arr){
            count[num - 1]++;
        }

        int outputIndex = 0;
        for (int i = 0; i < count.length; i++){
            while (count[i] > 0){
                arr[outputIndex++] = i + 1;
                count[i]--;
            }
        }
        return arr;
    }
}
