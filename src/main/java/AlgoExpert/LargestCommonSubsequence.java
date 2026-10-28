package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestCommonSubsequence {

   public static void main(String[] args){

       /*tring one = "ZXVVYZW";
       String two = "XKYKZPW";*/

       String one = "clement";
       String two = "antoine";
       longestCommonSubsequence(one, two);

   }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        Map<String, Integer> cache = new HashMap<>();
        String key = "";
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        Character anotherkey;
        String anotherKeyforMap = "";
        for(int i=0; i<str1.length(); i++){
            list1 = helper(str1.substring(i), str2);
            if(list1.size() > list2.size()){
                list2 = list1;
            }
            list1 = new ArrayList<>();
        }

        return list2;

    }

    public static List<Character> helper(String s1, String s2){
        Map<String, Integer> map = new HashMap<>();
        String key = "";
        List<Character> list = new ArrayList<>();
        for(int x=0; x<s1.length(); x++){
            for(int y=0; y<s2.length(); y++){
                //Character c = list.get(list.size()-1);
                int list_index = list.size()-1;
                //Integer fromMap = map.get();
                //for index of y, have I seen it previously (check in the map)
                //if(list.size()-1>=0 && map.containsKey(String.valueOf(list.get(list.size()-1))) && map.get(String.valueOf(list.get(list.size()-1))) > y){

                if(list.size()>0 && /*map.containsKey(String.valueOf(s2.charAt(y))) &&*/ map.get(String.valueOf(list.get(list.size()-1)))>=y){
                    break;
                }
                if(s1.charAt(x)==s2.charAt(y)){
                    list.add(s1.charAt(x));
                    map.put(String.valueOf(s1.charAt(x)), y);
                }
            }
        }
        return list;
    }

  public static int getIndexOf(String str, int startIndex, char chr){
   int index = -1;
   for(int i=startIndex; i<str.length(); i++){
       if(str.charAt(i)==chr){
           index = i;
           break;
       }
   }
   return index;
  }
}
