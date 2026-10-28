package AlgoExpert;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class SmallestSubstringContaining2 {

       public static void main(String[] args){
           //getStringTracker("abcd$ef$axb$c$");
           /*String bigString = "abcd$ef$axb$c$";
           String smallString = "$$abf";*/
           /*String bigString = "14562435612!88281932363365$412356789901";
           String smallString = "#!333333123!";*/
           String bigString = "abcdef";
           String smallString = "d";
           String result = smallestSubstringContaining(bigString, smallString);
           System.out.println(result);
       }

  public static String smallestSubstringContaining(String bigString, String smallString) {
    int bigStringStartIdx = -1;
    int bigStringEndIdx = bigString.length()-1;
    Map<String, List<Integer>> bigStringMap = getStringToMap(bigString);
    Map<String, List<Integer>> smallStringMap = new HashMap<>();
    int bigStringValueIdx = -1;
    String bigStringKey = null;
    String smallStringKey = null;
    String result1 = bigString;
    String result2 = bigString;
    boolean breakOut = false;
    int j=0;
    for(int i=0; i<bigString.length(); i++){
        bigStringStartIdx = i;
        bigStringKey = String.valueOf(bigString.charAt(i));
        for(j=0; j<smallString.length(); j++){
            smallStringKey = String.valueOf(smallString.charAt(j));
            bigStringValueIdx = getBigStringValueIdx(bigStringMap, smallStringMap, bigStringStartIdx, smallStringKey);
            if(bigStringValueIdx>=0) {
                smallStringMap = updateMap(smallStringMap, smallStringKey, bigStringValueIdx);
            }else{
                /*System.out.println("break");
                breakOut = true;
                break;*/
                if(j==0) return "";
                return result1.length()<result2.length()? result1: result2;
            }
        }//for
        System.out.println(">>>####");
        result1 = getStringFromMap(smallStringMap, bigString);
        if(result1.length()<smallString.length()) break;
        if(result1.length()<result2.length()){
            result2 = result1;
        }
        smallStringMap = new HashMap<>();
        if(breakOut) break;
    }//fpr
    return result1.length()<result2.length()? result1: result2;
  }

  public static String getStringFromMap(Map<String, List<Integer>> map, String bigString){
        // bigString = bigString+" ";
        List<Integer> masterList = new ArrayList<>();
        for (Map.Entry<String,List<Integer>> entry : map.entrySet()){
            masterList.addAll(entry.getValue());
        }
        Collections.sort(masterList);
        int lastIdx = masterList.size()-1;
        String str = null;
        if(masterList.get(lastIdx)==bigString.length()-1){
            str = bigString.substring(masterList.get(0));
        }else{
            str = bigString.substring(masterList.get(0), masterList.get(lastIdx)+1);
        }

        return str;
  }

  //gets the index of the char from the big String after the specified start index
  public static int getBigStringValueIdx(Map<String, List<Integer>> big_map, Map<String, List<Integer>> small_map, int startingidx, String key){
       /*Big Map:
         1. key does not exist
         2. key exists with single value in the list
         3. key exists with multiple value in the list
        Small Map:
         1.
       * */
       List<Integer> list = null;
       if(big_map.containsKey(key)){
           list = big_map.get(key);
       }

       if(list==null) return -1;
      if(small_map!=null && small_map.size()>0 && small_map.containsKey(key)) {
          List<Integer> small_list = small_map.get(key);
          int small_list_last_idx = small_list.get(small_list.size() - 1);
          for(int i=0; i<list.size(); i++){
               if(list.get(i)>=startingidx && list.get(i)>small_list_last_idx) return list.get(i);
          }
      }else{
          for(int i=0; i<list.size(); i++){
               if(list.get(i)>=startingidx) return list.get(i);
          }
      }

      return -1;
  }

  public static Map<String, List<Integer>>  updateMap(Map<String, List<Integer>> map, String key, int idx){
      /*1. key does not exist
        2. key exists
      * */
      List<Integer> list = null;
       if(map.containsKey(key)){
           map.get(key).add(idx);
       }else{
           list = new ArrayList<>();
           list.add(idx);
           map.put(key, list);
       }
       return map;
  }

  public static Map<String, List<Integer>> getStringToMap(String bs){
           ArrayList<Integer> tasks = new ArrayList<>();
           tasks.remove(0);
        Map<String, List<Integer>> cache = new HashMap<>();
        String key = "";
        List<Integer> value_list = null;
        for(int i=0; i<bs.length(); i++){
            key = String.valueOf(bs.charAt(i));
            if(cache.containsKey(key)){
                value_list = cache.get(key);
                value_list.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                cache.put(key, list);
            }
        }//for
        return cache;
    }
}
