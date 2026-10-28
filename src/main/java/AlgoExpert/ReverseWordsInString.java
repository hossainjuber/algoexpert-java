package AlgoExpert;

import java.util.*;

public class ReverseWordsInString {

   public static void main(String[] args){
       //String str = "test    ";
       String str = "Reverse These     Words";
       //String str = "1 12 23 34 56";
       String result =  reverseWords(str);
       System.out.println(result);
       System.out.println("The End");
   }

   public static String reverseWords(String str){
       StringBuffer sb = new StringBuffer();
       List<String> list = new ArrayList<>();
       for(int i=0; i<str.length(); i++){
           if(str.charAt(i)==' ' && !sb.isEmpty()){
               list.add(sb.toString());
               list.add(" ");
               sb = new StringBuffer();
           }else if(str.charAt(i)==' ' && sb.isEmpty()){
               list.add(" ");
           }else if(str.charAt(i)!=' '){
               sb.append(str.charAt(i));
           }
       }//for
       list.add(sb.toString());

       Collections.reverse(list);

       String result = String.join("", list);

       return result;
   }

   public static String reverseWordsInString(String string) {
       ArrayList<String> words = new ArrayList<>();
       int startOfWord =0;

       for(int idx=0; idx<string.length(); idx++){
           char character = string.charAt(idx);

           if(character == ' '){
               words.add(string.substring(startOfWord, idx));
               startOfWord = idx;
           }else if(string.charAt(startOfWord) == ' '){
               words.add(" ");
               startOfWord = idx;
           }
       }
       words.add(string.substring(startOfWord));
       Collections.reverse(words);
       return String.join(" ", words);
   }






    /*public static String reverseWordsInString(String string) {
       StringBuffer sb = new StringBuffer();
        String cs = "";
		int idx1 = 0;
		int idx2 = string.length()-1;
		for(int i=string.length()-1; i>=0; i--){
			cs = String.valueOf(string.charAt(i));
			if(cs.equals(" ") || i==0){
					if(i==0){
						idx1 = i;
					}else{
						idx1 = i+1;
					}
                    //idx1 = i;
					if(idx2==string.length()-1){
						sb.append(string.substring(idx1));
					}else{
						sb.append(string.substring(idx1, idx2));
					}
				  idx2 = idx1-1;
                  //if(i>2) sb.append(" ");
			}//if


		}//for
		return sb.toString();
	}*/


}
