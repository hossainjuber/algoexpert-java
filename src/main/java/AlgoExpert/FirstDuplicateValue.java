package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstDuplicateValue {
    public static class Info{
        Info(int k, int f, int s){
            key = k;
            f=first_index;
            s=second_index;
        }
        int key;
        int first_index;
        int second_index;
    }

    public static void main(String[]  args){
        int[] array = {2, 1, 5, 2, 3, 3, 4};
        int result = firstDuplicateValue(array);
    }

    public static int firstDuplicateValue(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        for(int i=0; i<array.length; i++){
            key = array[i];
            if(map.containsKey(key)){
                return key;
            }else{
                map.put(key, i);
            }
        }//for
        return -1;
    }
}
