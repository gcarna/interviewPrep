package src.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day2 {
    private static ArrayList<String> fromFileToArray(String filename){
        BufferedReader reader;
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                arrayList.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static int partOne(ArrayList<String> arr){
        int validPasswordCounter = 0;
        for(String line : arr){
            int min = Integer.parseInt(line.split("-")[0]);
            int max = Integer.parseInt(line.split("-")[1].split(" ")[0]);
            int counter = 0;
            String splittedString = line.split(":")[0];
            Character letter = splittedString.charAt(splittedString.length()-1);
            String password = line.split(" ")[2];
            for (int i = 0; i < password.length(); i++){
                if(password.charAt(i) == letter)
                    counter++;
            }
            if (counter >= min && counter <= max) validPasswordCounter++;
        }
        return validPasswordCounter;
    }

    private static int partTwo(ArrayList<String> arr){
        int validPasswordCounter = 0;
        int counter;
        for(String line : arr){
            int position1 = Integer.parseInt(line.split("-")[0]);
            int position2 = Integer.parseInt(line.split("-")[1].split(" ")[0]);
            String splittedString = line.split(":")[0];
            Character letter = splittedString.charAt(splittedString.length()-1);
            String password = line.split(" ")[2];
            counter = 0;
            if(password.charAt(position1-1) == letter) counter++;
            if(password.charAt(position2-1) == letter) counter++;
            if (counter == 1) validPasswordCounter++;
        }
        return validPasswordCounter;
    }

    public static void main(String[] args) {
        ArrayList<String> arr = fromFileToArray("day2.txt");
        System.out.println(partTwo(arr));
    }
}
