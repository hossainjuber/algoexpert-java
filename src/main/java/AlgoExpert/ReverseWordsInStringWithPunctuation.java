package AlgoExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReverseWordsInStringWithPunctuation {

   public static void main(String[] args){
       String str = "test, hello world!";
       //String str = "Reverse These Words";
       //String str = "1 12 23 34 56";
       String result =  reverseWordsInString(str);
       System.out.println(result);
       System.out.println("The End");
   }

   public static String reverseWordsInString(String str) {
       StringBuffer result = new StringBuffer();
       String[] array = str.split(" ");
       String word = null;
       String wordReversed = null;
       for(int i=0; i<array.length; i++){
           word = array[i];
           wordReversed = reverseWord(word);
           result.append(wordReversed);
           result.append(" ");
       }//for
       return result.toString();
   }

   public static String reverseWord(String word){
        StringBuffer sb = new StringBuffer();
        StringBuffer punctiation = new StringBuffer();
        Set<Character> set = new HashSet<>();
        set.add(',');
        set.add('.');
        set.add('!');
        for(int i=word.length()-1; i>=0; i--){
            if(set.contains(word.charAt(i))){
                punctiation.append(word.charAt(i));
            }else{
                sb.append(word.charAt(i));
            }

        }//for
       return sb.toString() + punctiation.toString();
   }









}
