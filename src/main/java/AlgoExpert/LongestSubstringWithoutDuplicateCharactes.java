package AlgoExpert;

import java.util.HashMap;
import java.util.HashSet;

//https://www.algoexpert.io/questions/Longest%20Substring%20Without%20Duplication
public class LongestSubstringWithoutDuplicateCharactes {

    public static void main(String[] args){
        //String str = "clementisacap";
        String str = "abcb";
        //mentisac
        getLongestSubstringWithoutDups(str);
    }

    public static String getLongestSubstringWithoutDups(String str) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        String key;
        Integer value;
        HashMap<String, Integer> map  = new HashMap<>();
        int beginIndex = 0;

        for(int i=0; i<str.length(); i++){
            key = String.valueOf(str.charAt(i));
            value = map.get(key);
            if(map.get(key)==null){
                map.put(key, i);
                sb1.append(key);
            }else{
                beginIndex = Math.max(beginIndex, value+1);
                map.put(key, i);
                sb1.append(key);
                if(sb1.length()>sb2.length()){
                    sb2 = sb1;
                }
                sb1 = new StringBuffer();
                sb1.append(String.valueOf(str.charAt(beginIndex)));
                sb1.append(key);
            }
        }

        return sb1.length()>sb2.length() ? sb1.toString(): sb2.toString();
    }


}
