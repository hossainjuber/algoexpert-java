package AlgoExpert;

import java.util.*;

//https://www.algoexpert.io/questions/Three%20Number%20Sum
public class ThreeNumberSum2 {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        int[] array = {12,3,1,2,-6,5,-8,6};
        //int targetSum = 0;
        //int[] array = {1, 2, 3};
        //int targetSum = 6;
        //int[] array = {8, 10, -2, 49, 14};
        int targetSum = 0;
        threeNumberSum(array, targetSum);
        System.out.println("The End");
    }

  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            int cv = array[i];
            int left = i+1;
            int right = array.length-1;

            while(left<right){
                int lv = array[left];
                int rv = array[right];
                int sum = cv + lv + rv;
                if(sum == targetSum){
                    Integer[] triplet = {cv, lv, rv};
                    result.add(triplet);
                    left++;
                    right++;
                }else if(sum<targetSum){
                    left++;
                }else{
                    right--;
                }
            }//while

        }//for
      return result;

	}

    public static List<List<Integer>>twoNumberSum(int[] array, HashSet<Integer> set, int targetSum, int num) {
        List<List<Integer>> result = new ArrayList<>();
        int theOtherNum = 0;
        HashSet<Integer> dup_tracker_set = new HashSet<>();
        for(int j=0; j<array.length; j++){
            theOtherNum = targetSum - array[j];
            if(set.contains(theOtherNum) && theOtherNum!=num && !dup_tracker_set.contains(j)){
                List<Integer> subList = new ArrayList<>();
                subList.add(array[j]);
                subList.add(theOtherNum);
                dup_tracker_set.add(j);
                result.add(subList);
            }
        }

        return result;
    }


}
