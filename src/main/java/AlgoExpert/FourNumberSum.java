package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

   public static void main(String[] args){
       int[] array = new int[]{7,6,4,-1,1,2};
       int targetSum = 16;
       fourNumberSum(array, targetSum);
   }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int diff = 0;
        int key = 0;
        List<List<Integer>> value = null;
        List<Integer> v = null;
        Integer[] set = new Integer[4];
        for(int i=0; i<array.length-1; i++){
            for(int j=i+1; j<array.length; j++){
                key = targetSum - array[i] - array[j];
                value = map.get(key);
                if(value==null) {
                    continue;
                }else{
                    set = new Integer[4];
                    for(int n=0; n<value.size(); n++){
                        v = value.get(n);
                        set[0] = v.get(0);
                        set[1] = v.get(1);
                        set[2] = array[i];
                        set[3] = array[j];
                    }
                    result.add(set);
                }//else
            }//inner for
            List<Integer> set_list = new ArrayList<>();
            for(int k=0; k<i; k++){
                key = targetSum - array[i] - array[k];
                value = map.get(key);
                if(value==null) {
                    value  = new ArrayList<>();
                    set_list = new ArrayList<>();
                    set_list.add(array[i]);
                    set_list.add(array[k]);
                    value.add(set_list);
                    map.put(key, value);
                    //map.put(k, value.add(array[j]));
                }else{
                    set = new Integer[4];
                    for(int m=0; m<value.size(); m++){
                        v = value.get(m);
                        set[0] = v.get(0);
                        set[1] = v.get(1);
                        set[2] = array[i];
                        set[3] = array[k];
                        result.add(set);
                    }
                    //map.put(key, );
                }//else
            }//for

        }//
        return result;
    }
}
