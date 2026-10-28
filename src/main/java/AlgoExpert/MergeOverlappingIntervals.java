package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

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
        // Write your code here.
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<int[]>();
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);

        for(int[] nextInterval : sortedIntervals){
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if(currentIntervalEnd >= nextIntervalStart){
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            }else{
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }//for
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
