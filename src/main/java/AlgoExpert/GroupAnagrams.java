package AlgoExpert;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args){
        List<String> l = new ArrayList<>();
        l.add("yo");
        l.add("act");
        l.add("flop");
        l.add("tac");
        l.add("foo");
        l.add("cat");
        l.add("oy");
        l.add("olfp");
        groupAnagrams(l);
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        if(words.size()==0) return new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ll = new ArrayList<>();
        List<String> l = null;
        String key = null;
        String word=null;
        Integer keyExists =0;
        for(int i=0; i<words.size(); i++){
            word = words.get(i).trim();
            if(word!=null && word.length()>0){
                char[] char_array = word.toCharArray();
                Arrays.sort(char_array);
                key = String.valueOf(char_array);
                if(!map.containsKey(key)){
                    map.put(key, i);
                    l = new ArrayList<>();
                    l.add(words.get(i));
                    ll.add(l);
                }else{
                    keyExists = map.get(key);
                    l = ll.get(keyExists);
                    l.add(words.get(i));
                }
            }
        }

        return ll;
    }
}
