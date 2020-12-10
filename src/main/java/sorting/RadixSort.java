package main.java.sorting;

public class RadixSort {

//    public static int[] sort(int[] array){
//        int max = getMax(array);
//
//
//    }

    private static int getMax(int[] array){
        int max = array[0];

        for (int n : array){
            if(n > max) max = n;
        }
        return max;
    }
}
