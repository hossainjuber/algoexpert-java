package AlgoExpert;

import java.util.*;


/*
* Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
* */
public class ApartmentHunting {

   public static void main(String[] args){
       String myWord = "boats";
       myWord.hashCode();
       //String myWord = "applepie";
        Set<String> set = new HashSet<>();
        set.add("oat");
        set.add("boa");
        set.add("at");
        set.add("boat");
       /*set.add("apple");
       set.add("pie");
       set.add("pi");*/
        //String result = wordParser(myWord, set);
       String result3 = wordParser3(myWord, set, new StringBuffer());
        System.out.println("result is: " + result3);
   }


   /*
   *  for(int i=0; i<str.length(); i++){
           sb.append(str.charAt(i));
           if(dictionary.contains(sb.toString())){
               result.append(" ");
               result.append(sb.toString());
               sb = new StringBuffer();
           }
       }*/
   public static String wordParser3(String input, Set<String> set, StringBuffer result){
       StringBuffer sb = new StringBuffer();
       int head = 0;
       for(int i=0; i < input.length(); i++){
           sb.append(input.substring(head, i));
           if(set.contains(sb.toString())){
               result.append(sb.toString());
               result.append(" ");
           }
           wordParser3(input.substring(i+1, input.length()-1), set, result);
       }//for
       return result.toString();
   }


    public static String SegmentString(String input, Set<String> dict) {
        if (dict.contains(input)) return input;
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = SegmentString(suffix, dict);
                if (segSuffix != null) {
                    return prefix + " " + segSuffix;
                }
            }
        }
        return null;
    }


    public static String wordParser2(String str, Set<String> dictionary){

       for(int i=0; i<str.length(); i++){
           //check pre-fix
           //check suffix, here we call another function and pass in the index
       }
       return null;
    }

   public static String wordParser(String str, Set<String> dictionary){
       //defensive code
       if(str==null || str.length()<1) return "i am here";
       StringBuffer sb = new StringBuffer();
       StringBuffer result = new StringBuffer();
       int head = 0;

       for(int i=0; i<str.length(); i++){
           sb.append(str.charAt(i));
           if(dictionary.contains(sb.toString())){
               result.append(" ");
               result.append(sb.toString());
               sb = new StringBuffer();
           }
       }
       return result.toString().trim();
   }




}
