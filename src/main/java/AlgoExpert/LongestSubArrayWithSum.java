package AlgoExpert;

import java.util.*;


/*
* Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
* */
public class LongestSubArrayWithSum {

   public static void main(String[] args){
       //int[] array = {1,2,3,4,3,3,1,2,1,2};
       //int[] array = { 1,2,3,4,3,3,1,2,1};
       //int[] array = {1,2,3,4,0,0,0,0,3,3,1,2,1};
       //int[] array = {0,0,0,0,0,1,0,0,0,0};
       //int[] result = longestSubarrayWithSum(array, 1);

        //int[] array = new int[]{ 1, 2, 3, 4, 3, 3, 1, 2, 1 };
        //int targetSum = 10;

       int[] array = new int[]{0, 54, 10, 499, 2212, 4059, 1, 2, 3, 1, 3};
       int targetSum = 0;

        longestSubarrayWithSum(array, targetSum);
    }

    public static int[] longestSubarrayWithSum(int[] array, int targetSum) {
        Map<Integer, Integer[]> map = new HashMap<>();
        int sum = array[0];
        int i = 0;
        int startIdx = i;
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int j=0; j<array.length; j++){
            sum = array[j];
            startIdx=j;
            for( i=j+1; i<array.length; i++){
                sum = sum + array[i];
                if(sum==targetSum){
                    int endIdx = i;
                    map.put(endIdx-startIdx, new Integer[]{startIdx, endIdx});
                    max_heap.add(endIdx-startIdx);
                    //startIdx = endIdx;
                    //sum = array[j];
                    //break;
                }else if(sum>targetSum){
                    sum = 0;
                    break;
                }
            }//for
        }//for
        Integer[] result = map.get(max_heap.poll());
        return result!=null? new int[]{result[0], result[1]} :  new int[]{};
    }



}
