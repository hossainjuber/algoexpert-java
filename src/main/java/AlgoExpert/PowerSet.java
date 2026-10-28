package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Powerset
public class PowerSet {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> ll =  powerset(list);
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        ll.add(l);
        for(int i=0; i<array.size(); i++){
            int length = ll.size();
            for(int j=0; j<length; j++){
                List<Integer> copyList = new ArrayList<Integer>(ll.get(j));
                copyList.add(array.get(i));
                ll.add(copyList);
            }
        }
        return ll;
    }

}
