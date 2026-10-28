package AlgoExpert;

import java.util.*;

public class SmallestSubstringContaining {

       public static void main(String[] args){
           /**
            *   "bigString": "abcdefghijklmnopqrstuvwxyz",
            *   "smallString": "aajjttwwxxzz"
            *
            *   "bigString": "abzacdwejxjftghiwjtklmnopqrstuvwxyz",
            *   "smallString": "aajjttwwxxzz"
            *
            *     "bigString": "1456243561288281932363365412356789901!",
            *   "smallString": "123!"
            */
           String bigString = "abzacdwejxjftghiwjtklmnopqrstuvwxyz";
           String smallString = "aajjttwwxxzz";
           //String smallString = "uvwx";
           smallestSubstringContaining(bigString, smallString);
       }

    public static String smallestSubstringContaining(
            String bigString, String smallString
    ) {
        Map<String, Integer> currMap = new HashMap<>();
        Map<String, Integer> smallMap = getCharCountMap(smallString);
        int left = 0;
        int right = 0;
        int unique = 0;
        String str1 = "";
        String str2 = "";
        while(right<=bigString.length()){
            currMap = getCharCountMap(bigString.substring(left, right));
            if(isEqualMaps(currMap, smallMap)){

                str1 = bigString.substring(left, right);
                if(right==bigString.length()-2) {
                    str1 = bigString.substring(left);
                }
                if(str2.length()==0 || str1.length()<str2.length()){
                    str2 = str1;
                }
                left++;
            }else{
                right++;
            }
        }
        return str2;
    }

    public static boolean isEqualMaps(Map<String, Integer>m1, Map<String,Integer>m2) {
        for(Map.Entry<String, Integer> entry : m2.entrySet()){
            if(!m1.containsKey(entry.getKey())){
                return false;
            }
            if(m1.get(entry.getKey())< entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> getCharCountMap(String str){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            String key = String.valueOf(str.charAt(i));
            if(!map.isEmpty() && map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }//for
        return map;
    }
}
