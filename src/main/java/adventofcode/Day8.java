package main.java.adventofcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static main.java.adventofcode.Utils.fromFileToArrayOfString;

public class Day8 {

    private static void day8(ArrayList<String> instructions){
        int acc = 0;
        int j = 0;
        int i = 0;
        HashSet<Integer> visitedInstructions = new HashSet<>();
        while (i < instructions.size()){
            boolean isChanged = false;
            acc = 0;
            j = 0;
            visitedInstructions.clear();
            while (j < instructions.size()){

                if(visitedInstructions.contains(j)){
                    System.out.println("Loop Detected");
                    System.out.println(acc);
                    break;

                }
                visitedInstructions.add(j);


                String instruction = fetchInstruction(instructions.get(j));
                Integer amount = Integer.parseInt(fetchAmount(instructions.get(j)));

                if(("nop".equals(instruction) || "jmp".equals(instruction)) && !isChanged && j == i){
                    if("nop".equals(instruction)){
                        instruction = "jmp";
                    }

                    else if("jmp".equals(instruction)){
                        instruction = "nop";
                    }
                    isChanged = true;
                }

                if("jmp".equals(instruction)){
                    j = j + amount;
                } else j++;

                if("acc".equals(instruction)){
                    acc += amount;
                }

            }
            if(j == instructions.size()){
                System.out.println("Program Terminated");
                System.out.println(acc);
                break;
            }
            i++;
        }

    }

    private static String fetchInstruction(String s){
        return s.split(" ")[0];
    }

    private static String fetchAmount(String s){
        return s.split(" ")[1];
    }



    public static void main(String[] args) {
        ArrayList<String> arr = fromFileToArrayOfString("src/main/resources/day8.txt");
        day8(arr);
    }
}
