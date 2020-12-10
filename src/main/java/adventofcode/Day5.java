package main.java.adventofcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static main.java.adventofcode.Utils.fromFileToArrayOfString;

public class Day5 {

    private static void day5(ArrayList<String> boardingPasses){
        int[] rows = new int[128];
        int[] columns = new int[8];
        ArrayList<Integer> seatIdList = new ArrayList<>();

        for (int i = 0; i < rows.length; i++)
            rows[i] = i;

        for (int i = 0; i < columns.length; i++)
            columns[i] = i;
        int maxSeatId = 0;
        for (String bp : boardingPasses){
            int row = decode(rows, bp, 0,128, 'F');
            int column = decode(columns, bp.substring(7),0, 8, 'L');
            int seatId = (row * 8 ) + column;
            if(seatId > maxSeatId) maxSeatId = seatId;
            seatIdList.add(seatId);
        }
        System.out.println(maxSeatId);

        Collections.sort(seatIdList);

        for (int i = 1; i < seatIdList.size() - 1; i++) {
            int previousSeatId = seatIdList.get(i - 1);
            int nextSeatId = seatIdList.get(i + 1);
            int currentSeatId = seatIdList.get(i);
            if (previousSeatId == currentSeatId - 2 && nextSeatId == currentSeatId + 1)
                System.out.println(currentSeatId - 1);
        }
    }

    private static int decode(int[] arr, String bp, int start, int end, char left){
        if(end - start < 3){
            if(bp.charAt(0) == left) return arr[start];
            else return arr[start + 1];
        }
        int mid = (start + end ) / 2;
        if(bp.charAt(0) == left)
            return decode(arr, bp.substring(1), start, mid, left);
        else {
            return decode(arr, bp.substring(1), mid, end, left);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arr = fromFileToArrayOfString("src/main/resources/day5.txt");
        day5(arr);
    }
}
