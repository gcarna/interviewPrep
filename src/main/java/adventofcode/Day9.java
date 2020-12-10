package main.java.adventofcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static main.java.adventofcode.Utils.fromFileToArrayOfLong;

public class Day9 {

    private static void day9(ArrayList<Long> numbers){
//        System.out.println(numbers);
        int PREAMBOL_SIZE = 25;
        HashSet<Long> acceptedNumbers = new HashSet<>();
        Long num = 0L;

        for (int i = 0; i < PREAMBOL_SIZE; i ++){
            for (int j = 0; j < PREAMBOL_SIZE; j++){
                if(j != i)
                    acceptedNumbers.add(numbers.get(i) + numbers.get(j));
            }
        }

        for (int i = PREAMBOL_SIZE; i < numbers.size(); i ++){
            num = numbers.get(i);
            if(!acceptedNumbers.contains(num)) {
                System.out.println(num);
                break;
            }
            acceptedNumbers.clear();

            for (int j = i - (PREAMBOL_SIZE - 1); j <= i; j++){
                for (int k = i - (PREAMBOL_SIZE - 1); k <= i; k++){
                    if (k != j)
                     acceptedNumbers.add(numbers.get(j) + numbers.get(k));
                }
            }
        }

        //part two
        long sum;
        for (int i = 0; i < numbers.size(); i++){
            sum = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++){
                sum += numbers.get(j);
                if (sum > num) break;
                else if (sum == num){
                    System.out.println("sum found");
                    System.out.println(getMax(numbers.subList(i, j+1)) + getMin(numbers.subList(i, j+1)));
                }
            }
        }
    }


    private static long getMax(List<Long> numbers){
        long max = numbers.get(0);
        for (long num : numbers){
            if (num > max) max = num;
        }
        return max;
    }

    private static long getMin(List<Long> numbers){
        long min = numbers.get(0);
        for (long num : numbers){
            if (num < min) min = num;
        }
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Long> arr = fromFileToArrayOfLong("src/main/resources/day9.txt");
        day9(arr);
    }
}
