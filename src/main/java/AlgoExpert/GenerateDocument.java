package AlgoExpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

       public static void main(String[] args){
            /*String character = "Bste!hetsi ogEAxpelrt x ";
            String doc = "AlgoExpert is the Best!";*/
            /*String character = "a hsgalhsa sanbjksbdkjba kjx";
            String doc = "";*/
           /*String character = "&*&you^a%^&8766 _=-09     docanCMakemthisdocument";
           String doc = "Can you make this document &";*/
           /*String character = "aheaolabbhb";
           String doc = "hello";*/
           /*String character = "Bste!hetsi ogEAxpelrt x ";
           String doc = "AlgoExpert is the Best!";*/

           String character = "A";
           String doc = "a";
           generateDocument(character, doc);
       }

    public static boolean generateDocument(String characters, String document) {
        //if(characters.length()>document.length()) return false;
        if(document.length()==0) return true;
        Map<String, Integer> str_map = getFrequencyMap(characters);
        Map<String, Integer> doc_map = getFrequencyMap(document);
        for(Map.Entry<String, Integer> entry : doc_map.entrySet()){
            if(!str_map.containsKey(entry.getKey())) return false;
            if(entry.getValue()>str_map.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> getFrequencyMap(String str){

        Map<String, Integer> map = new HashMap<>();
        String key = "";
        Integer value;
        for(int i=0; i<str.length(); i++){
            key = String.valueOf(str.charAt(i));
            value = map.get(key);
            if(!map.containsKey(key)){
                map.put(key, 1);
            }else{
                value = value+1;
                map.put(key, value);
            }
        }//for
        return map;
    }


}
