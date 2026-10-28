package AlgoExpert;

import java.util.*;

public class LargestRange2 {

    public static void main(String[] str){
        //int[] range = {5, 1, 2, 3, 0, -5};
        int[] range = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        //int[] range = {0, -5, 9, 19, -1, 18, 17, 2, -4, -3, 10, 3, 12, 5, 16, 4, 11, 7, -6, -7, 6, 15, 12, 12, 2, 1, 6, 13, 14, -2};
        //int[] range = {4,2,1,3};
        int[] result = largestRange(range);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] largestRange(int[] array) {
        // Write your code here.
        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, int[]> cache = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<array.length; i++){
            map.put(array[i], false);
        }
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i]) && map.get(array[i])==false){
                int lowerBound = getLowerBound(i, map);
                int upperBound = getUpperBound(i, map);
                cache.put(upperBound-lowerBound, new int[]{lowerBound, upperBound});
                pq.add(upperBound-lowerBound);
            }
        }//for
        return cache.get(pq.poll());
    }//largestRnage

    public static int getLowerBound(int idx, Map<Integer, Boolean> map){
        int range = map.size();
        int i=0;
        //idx--;
        while(i<range){
            if(map.containsKey(idx)){
                map.put(idx,true);
                idx--;
            }else{
                break;
            }
            i++;
        }//while
        return ++idx;
    }

    public static int getUpperBound(int idx, Map<Integer, Boolean> map){
        int range = map.size();
        int i=0;
        //idx++;
        while(i<range){
            if(map.containsKey(idx)){
                map.put(idx, true);
                idx++;
            }else{
                break;
            }
            i++;
        }//while
        return --idx;
    }

}
