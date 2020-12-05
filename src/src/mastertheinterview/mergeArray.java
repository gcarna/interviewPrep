package src.mastertheinterview;

import java.util.ArrayList;

public class mergeArray {

    public static ArrayList<Integer> mergeArray(int[] arr1, int[] arr2){
        ArrayList<Integer> mergedArray = new ArrayList();
        int i = 0, j = 0;

        while ( i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                mergedArray.add(arr1[i]);
                i++;
            } else {
                mergedArray.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length){
            mergedArray.add(arr1[i]);
            i++;
        }

        while (j < arr2.length){
            mergedArray.add(arr2[j]);
            j++;
        }
        return mergedArray;
    }
}