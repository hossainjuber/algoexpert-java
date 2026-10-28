package AlgoExpert;

import java.util.HashSet;
import java.util.Set;

public class zeroSumSubArray {
    public static void main(String[] str){
        //int[] range = {5, 1, 2, 3, 0, -5};
        //int[] nums = new int[]{1, 2,-2, 3};
        int[] nums = new int[]{2, 3, 4, -5, -3, 5, 5};
        boolean result = zeroSum(nums);
        System.out.println(result);

    }
    public static boolean zeroSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int element : nums){
            sum = sum + element;
            //if(element==0 || set.contains(sum) || sum==0){
            if(element==0 || set.contains(-element)){
                return true;
            }
            set.add(element);
        }//for
        return false;
    }
}
