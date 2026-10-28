package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCharactersForWords {

    public static void main(String[] str){
        String[] words = {"this", "that", "did", "deed", "them!", "a"};
        String[] result = minimumCharactersForWords(words);
        System.out.println("The End");
    }

    public static String[] minimumCharactersForWords(String[] words) {
        Map<String, Integer> master_freq = new HashMap<>();
        //Map<String, Integer> freq = new HashMap<>();
        String key = "";
        Integer value = 0;
        int array_size=0;
        //for(String word : words){
        for(int i=0; i<words.length; i++){
            Map<String, Integer> freq = frequencyCount(words[i]);
            //if(master_freq.size()==0) master_freq = freq;
            for (Map.Entry<String, Integer> entry : freq.entrySet()){
                key = entry.getKey();
                if(master_freq.containsKey(key) && master_freq.get(key)<freq.get(key)){
                    master_freq.put(key, freq.get(key));
                }else if(!master_freq.containsKey(key)){
                    master_freq.put(key, freq.get(key));
                }
            }//for
        }//for

        //convert master_freq into array
        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : master_freq.entrySet()){
            key = entry.getKey();
            value = entry.getValue();
            int dupes = 0;
            while(dupes<value){
                list.add(key);
                dupes++;
            }//while
        }//for
        //list.toArray(new Foo[0]);,
        return list.toArray(new String[list.size()]);
    }

    public static Map<String, Integer> frequencyCount(String str){
        if(str==null || str.length()<1) return null;
        Map<String, Integer> freq = new HashMap<>();
        String key = "";
        Integer value = 0;
        for(int i=0; i<str.length(); i++){
            key = String.valueOf(str.charAt(i));
            if(freq.containsKey(key)){
                value = freq.get(key);
                freq.put(key, value+1);
            }else{
                freq.put(key, 1);
            }
        }//for
        return freq;
    }//frequencyCount
}
