package main.java.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Day1 {
    static int SUM = 2020;

    private static ArrayList<Integer> fromFileToArray(String filename){
        BufferedReader reader;
        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                arrayList.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static int partOne(ArrayList<Integer> arr){
        HashSet<Integer> hashSet = new HashSet<>(arr.size());

        for (int i=0; i < arr.size(); i++){
            hashSet.add(SUM - arr.get(i));
        }

        for (int i=0; i < arr.size(); i++){
            if (hashSet.contains(arr.get(i))){
                return (SUM - arr.get(i)) * arr.get(i);
            }
        }
        return -1;
    }

    private static int partTwo(ArrayList<Integer> arr){
        HashSet<Integer> hashMap = new HashSet<>(arr.size());

        for (int i=0; i < arr.size(); i++) {
            int current_sum = SUM - arr.get(i);
            for (int j = 1; j < arr.size(); j++) {
                if (hashMap.contains(current_sum - arr.get(j))){
                    int num1 = arr.get(i);
                    int num2 = SUM - (arr.get(i) + arr.get(j));
                    int num3 = arr.get(j);
                    return num3 * num2 * num1;
                }
                hashMap.add(arr.get(j));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = fromFileToArray("input.txt");
        System.out.println(partTwo(arr));
        System.out.println(partOne(arr));



    }
}