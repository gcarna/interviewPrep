package main.java.mastertheinterview;

import java.util.HashSet;

public class GoogleQuestion {

    static public int firstOccurrence(int[] arr){
        HashSet<Integer> hashSet = new HashSet();
        for (int num: arr) {
            if(hashSet.contains(num)) return num;
            hashSet.add(num);
        }
        //O(n)
        return -1;
    }
}
