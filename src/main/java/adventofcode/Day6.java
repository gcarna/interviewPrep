package main.java.adventofcode;

import java.util.*;

import static main.java.adventofcode.Utils.fromFileToArrayOfString;

public class Day6 {

    private static void day6(ArrayList<String> questions){
        questions.add("");
        HashSet<Character> hashSet = new HashSet<>();
        int questionsCount = 0;
        for (String q : questions){
            for (int i = 0; i < q.length(); i++){
                Character current = q.charAt(i);
                if(!hashSet.contains(current)) questionsCount++;
                hashSet.add(current);
            }
            if("".equals(q)) hashSet.clear();
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        int groupSize = 0;
        int questionsCount2 = 0;
        for (String q : questions){
            for (int i = 0; i < q.length(); i++){
                Character current = q.charAt(i);
                if(hashMap.containsKey(current)) {
                    int count = hashMap.get(current);
                    hashMap.put(current, ++count);
                } else {
                    hashMap.put(current, 1);
                }
            }
            if("".equals(q)){
                for (Character key : hashMap.keySet()){
                    if(hashMap.get(key) == groupSize){
                        questionsCount2++;
                    }
                }
                hashMap.clear();
                groupSize = 0;
            } else groupSize++;
        }
        System.out.println(questionsCount2);


    }



    public static void main(String[] args) {
        ArrayList<String> arr = fromFileToArrayOfString("src/main/resources/day6.txt");
        day6(arr);
    }
}
