package main.java.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {
    private static ArrayList<ArrayList<Character>> fromFileToMatrix(String filename){
        BufferedReader reader;
        ArrayList<ArrayList<Character>> matrixList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                ArrayList<Character> row = new ArrayList<>();
                if(line != null){
                    for (int i = 0; i < line.length(); i++){
                        row.add(line.charAt(i));
                    }
                    matrixList.add(row);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrixList;
    }

    private static long partOne(ArrayList<ArrayList<Character>> arr, int stepRight, int stepDown){
        int rowsLength = arr.size();
        int columnsLength = arr.get(0).size();
        long treesCount = 0;
        int right = 0;
        for (int i = 0; i < rowsLength; i = i + stepDown){
            if(arr.get(i).get(right) == '#'){
                treesCount++;
            }
            right = (right + stepRight)  % columnsLength;

        }
        return treesCount;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> arr = fromFileToMatrix("src/main/resources/day3.txt");
        System.out.println(partOne(arr, 3, 1));

        long partTwo = partOne(arr,1,1) * partOne(arr, 3, 1) * partOne(arr,5,1) * partOne(arr, 7, 1) * partOne(arr, 1, 2);

        System.out.println(partTwo);



    }
}
