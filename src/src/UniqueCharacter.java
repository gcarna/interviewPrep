package src;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacter {

    private static boolean uniqueCharacter(String s) {
        Map map = new HashMap<String, Integer>();

        for (int i=0; i<s.length(); i++){
            map.put(s.charAt(i), 0);
        }
        for (int i=0; i<s.length(); i++){
            char key = s.charAt(i);
            map.put(key, (int)map.get(key)+1);
            if((int)map.get(key)>1) return false;
        }
        return true;
    }

    private static boolean uniqueCharacter2(String s) {
        boolean[] arr = new boolean[256];
        for (int i=0; i<s.length(); i++){
            if(arr[s.charAt(i)]){
                return false;
            }else{
                arr[s.charAt(i)] = true;
            }
        }
        return true;
    }

    private static boolean uniqueCharacter3(String s) {
        long checker = 0;
        for (int i=0; i<s.length();i++){
            long singleBit = 1 << (s.charAt(i));
            if((singleBit & checker) > 0){
                return false;
            }
            checker = checker | singleBit;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueCharacter3("Aa"));
    }
}
