package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals2 {

    public static void main(String[] args){
        int[] a1 = {1,2};
        int[] a2 = {3,5};
        int[] a3 = {4,7};
        int[] a4 = {6,8};
        int[] a5 = {9,10};
        int[][] array = {a5, a2, a3, a4, a1};
        mergeOverlappingIntervals(array);
        System.out.println("The End");
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        int[][] copy = intervals.clone();
        Arrays.sort(copy, (a, b)-> Integer.compare(a[0], b[0]));
        List<int[]> mergedInterval = new ArrayList<>();
        int[] currentInterval = copy[0];
        mergedInterval.add(currentInterval);
        for(int i=1; i<copy.length; i++){
            int prev_inv1_head = copy[i-1][0];
            int prev_inv1_tail = copy[i-1][1];
            int inv1_head = copy[i][0];
            int inv1_tail = copy[i][1];

            if(prev_inv1_tail >= inv1_head){
                currentInterval[1] = Math.max(prev_inv1_tail, inv1_tail);
            }else{
                currentInterval = copy[i];
                mergedInterval.add(currentInterval);
            }
        }//for
        //return mergedInterval.toArray();
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}
