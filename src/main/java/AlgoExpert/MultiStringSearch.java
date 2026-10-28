package AlgoExpert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://www.algoexpert.io/questions/Multi%20String%20Search
public class MultiStringSearch {

    public static void main(String[] str){
        String bigString = "this is a biggger string";
        String[] samllStrings = {"this", "yo", "is", "a", "big", "string"};
        multiStringSearch(bigString, samllStrings);
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        HashSet<String> set = getSetOfStrings(bigString);
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i=0; i<smallStrings.length; i++){
            if(set.contains(smallStrings[i])){
                result.add(i, true);
            }else{
                result.add(i, false);
            }
        }
        return result;
    }

    public static HashSet<String> getSetOfStrings(String str){
        HashSet<String> set = new HashSet<>();
        String[] array = str.split(" ");
        set.add(String.valueOf(array));
        for(String s: array){
            set.add(s);
        }
        return set;
    }
}
