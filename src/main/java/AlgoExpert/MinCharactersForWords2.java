package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MinCharactersForWords2 {

    public static void main(String[] str){
        String[] words = {"this", "that", "did", "deed", "them!", "a"};
        char[] result = minimumCharactersForWords(words);
        System.out.println("The End");
    }

    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> masterMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++ ){
            String word = words[i];
            for(int j=0; j<word.length(); j++){
                Character key = word.charAt(j);
                Integer value = map.get(key);
                if(!map.containsKey(key)){
                    map.put(key, 1);
                }else{
                    value = value+1;
                    map.put(key, value);
                }

            }//for
            updateMasterMap(masterMap, map);
            map = new HashMap<>();
        }//for
        return convertMapToLetters(masterMap);
    }

    public static void updateMasterMap(Map<Character, Integer> masterMap,
                                Map<Character, Integer> map ){
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if(!masterMap.containsKey(key) || masterMap.get(key)==1){
                masterMap.put(key, value);
            }else {
                masterMap.put(key,Math.max(value, masterMap.get(key)));
            }
        }
        System.out.println("I am here");
    }

    public static char[] convertMapToLetters(Map<Character, Integer> map){
        List<Character> list = new ArrayList<>();
        int count = 1;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            count = entry.getValue();
            while(count>0){
                list.add(entry.getKey());
                count--;
            }
        }

        char[] chars = new char[list.size()];
        IntStream.range(0, list.size()).forEach(i -> chars[i] = list.get(i));
        return chars;
    }
}
