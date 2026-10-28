package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
/*
* 1. Identify the substring in a list with beginning index and end index
* 2. collapse the indexes into a single pair of beginning and end index
* 3. iterate of this collapsed index list and write it out into a StringBuilder
* */
public class UnderscorifySubsctirng5 {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        String s1 = "testtest is a testtest to see if testestest it works";
        String s2 = "test";
        //_test_this is a _testtest_ to see if _testestest_ it works_
        List<List<Integer>> ll = getSubStringLocations(s1, s2);
        ll = collapseOverlappingindexes(ll);
        System.out.println("The End");

    }

    public static List<List<Integer>> collapseOverlappingindexes(List<List<Integer>> list){
        if(list.size()==0) return list;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = list.get(0);
        List<Integer> newPair = null;
        for(int i=1; i<list.size(); i++){
        //for(List l : list){
            List<Integer> curr = list.get(i);
            if(prev.get(1)+1>=curr.get(0) || result.get(result.size()-1).get(1)+1>=curr.get(0) ){
                newPair = new ArrayList<>();
                newPair.add(prev.get(0));
                newPair.add(curr.get(1));
                result.add(newPair);
            }else{
                result.add(curr);
            }
            prev = curr;
        }//for
        return result;
    }

    public static List<List<Integer>> getSubStringLocations(String str, String sub){
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = null;
        for(int i=0; i<str.length(); i++){
            if(i+sub.length()<=str.length()) {
                String currSub = str.substring(i, i + sub.length());
                if (currSub.equals(sub)) {
                    l = new ArrayList<>();
                    l.add(i);
                    l.add(i + sub.length() - 1);
                    ll.add(l);
                }//if
            }
        }//for
        return ll;
    }



}
