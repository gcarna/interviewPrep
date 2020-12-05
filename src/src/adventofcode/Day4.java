package src.adventofcode;

import org.junit.platform.commons.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day4 {

    private static int day4(ArrayList<String> arr, String part){
        ArrayList<HashMap<String, String>> arrayOfMaps = new ArrayList<>();
        int passportIndex = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        for(String line : arr){
            if(line.equals("")){
                arrayOfMaps.add(passportIndex, hashMap);
                hashMap = new HashMap<>();
            } else{
                String[] splittedBySpace = line.split(" ");
                for (int i=0; i < splittedBySpace.length; i++){
                    hashMap.put(splittedBySpace[i].split(":")[0], splittedBySpace[i].split(":")[1]);
                }
            }
        }
        arrayOfMaps.add(passportIndex, hashMap);
        int validPassportCount = 0;
        boolean isValidPassport;
        for(HashMap passport : arrayOfMaps){
            isValidPassport = true;
            if(!passport.containsKey("byr")) isValidPassport = false;
            if(!passport.containsKey("iyr")) isValidPassport = false;
            if(!passport.containsKey("eyr")) isValidPassport = false;
            if(!passport.containsKey("hgt")) isValidPassport = false;
            if(!passport.containsKey("hcl")) isValidPassport = false;
            if(!passport.containsKey("ecl")) isValidPassport = false;
            if(!passport.containsKey("pid")) isValidPassport = false;

            if("two".equals(part)) isValidPassport = partTwoValidityCheck(passport);


            if(isValidPassport) validPassportCount++;

        }
        return validPassportCount;
    }

    private static boolean partTwoValidityCheck(HashMap<String, String> passport){
        Integer byr;
        Integer iyr;
        Integer eyr;
        String hgt;
        String hcl;
        String ecl;
        String pid;
        boolean isValidPassport = true;
            try {
                byr = Integer.parseInt(passport.get("byr"));
                iyr = Integer.parseInt(passport.get("iyr"));
                eyr = Integer.parseInt(passport.get("eyr"));
                hgt = passport.get("hgt");
                hcl = passport.get("hcl");
                ecl = passport.get("ecl");
                pid = passport.get("pid");
            } catch (Exception e) {
                return false;
            }
            if (byr < 1920 || byr > 2002) isValidPassport = false;
            if (iyr < 2010 || iyr > 2020) isValidPassport = false;
            if (eyr < 2020 || eyr > 2030) isValidPassport = false;
            if (hgt.matches("[0-9]+(cm|in)")) {
                String unit = hgt.substring(hgt.length() - 2);
                Integer num = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
                if ("cm".equals(unit)) {
                    if (num < 150 || num > 193) isValidPassport = false;
                }
                if ("in".equals(unit)) {
                    if (num < 59 || num > 76) isValidPassport = false;
                }
            } else {
                isValidPassport = false;
            }
            if (!hcl.matches("^#[0-9a-f]{6}$")) isValidPassport = false;
            if (!ecl.matches("(amb|blu|brn|gry|grn|hzl|oth)")) isValidPassport = false;
            if (!pid.matches("[0-9]{9}")) isValidPassport = false;

        return isValidPassport;
    }

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

    public static void main(String[] args) {
        ArrayList<String> arr = fromFileToArray("day4.txt");
        System.out.println(day4(arr, "one") );
        System.out.println(day4(arr, "two") );
    }
}
