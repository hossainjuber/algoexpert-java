package AlgoExpert;

import java.util.HashMap;
import java.util.Map;

//https://www.algoexpert.io/questions/Longest%20Substring%20Without%20Duplication
public class LongestSubstringWithoutDuplicateCharactes2 {

    public static void main(String[] args){
        //String str = "clementisacap";
        //String str = "abccdeaabbcddef";
        //String str = "abcdeabcdefc";
        String str = "abcdeabcdefc";
        getLongestSubstringWithoutDups(str);
    }

    public static String getLongestSubstringWithoutDups(String str) {
        Map<String, Integer> map = new HashMap<>();
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		String key = "";
		Integer value = 0;
		int begin_index = 0;
		for(int i=0; i<str.length(); i++){
            key = String.valueOf(str.charAt(i));
            value = map.get(key);
            if(value == null || value<begin_index){
                sb1.append(key);
                map.put(key, i);
            }else{
                begin_index = Math.max(begin_index, value + 1);
                if(sb1.length() >= sb2.length()){
                    sb2 = sb1;
                    sb1 = new StringBuffer();
                    sb1.append(str.substring(begin_index, i+1));
                }else{
                    sb1 = new StringBuffer();
                }
                map.put(key, i);
            }
		}
    return sb1.length()>sb2.length() ? sb1.toString() : sb2.toString();
    }


}
