package AlgoExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInString2 {

   public static void main(String[] args){
       //String str = "    test";
       //"best!  the  is AlgoExpert " "best! "
       String str = "Reverse These        Words";
       //String str = "1 12 23 34 56";
	    //String str = "a ab a";
       String result =  reverseWordsInString(str);
       System.out.println(result);
   }

    public static String reverseWordsInString(String string) {
        // Write your code here.
        List<String> words = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i <string.length(); i++){
            char myChar = string.charAt(i);
            if(myChar!=' '){
                sb.append(myChar);
            }else{
                //if(!sb.isEmpty()){
                words.add(sb.toString());
                sb = new StringBuffer();
                //}
                //words.add(" ");
            }
        }//for
        words.add(sb.toString());
        Collections.reverse(words);
        return String.join(" ", words);
    }

}
