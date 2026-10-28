package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class ContinuousMedianHandler2 {

    public static void main(String[] str){
        insert(5);
        insert(10);
        double median = getMedian();
        insert(100);
        median = getMedian();


    }//main

    static double median = 0;
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void insert(int number) {
        nums.add(number);
        int size = nums.size();
        if(size%2>0) {
            //odd length
            if(size==1) {
                median = nums.get(0);
            }else{
                int idx = size/2;
                median = nums.get(idx);
            }

        }else{
            if(size==2){
                Double result = Double.valueOf(nums.get(0)+nums.get(1));
                median = result/2;
            }else{
                int mid = size/2;
                median = (nums.get(mid-1)+nums.get(mid)) /2;
            }
        }
    }

    public static double getMedian() {
      return median;
    }
}


