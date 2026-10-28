package AlgoExpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LargestRange {

    public static void main(String[] str){
        //int[] range = {5, 1, 2, 3, 0, -5};
        //int[] range = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] range = {0, -5, 9, 19, -1, 18, 17, 2, -4, -3, 10, 3, 12, 5, 16, 4, 11, 7, -6, -7, 6, 15, 12, 12, 2, 1, 6, 13, 14, -2};
        //int[] range = {4,2,1,3};
        int[] result = largestRange(range);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }


    public static class XY{
        int x;
        int y;
        public XY(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static int[] largestRange(int[] array){
        int start_idx = 0;
        int end_idx = 0;
        HashMap<Integer, Integer[]> map = new HashMap<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(array);
        for(int i=1; i<array.length; i++){
            if(array[i-1]+1 == array[i] || array[i-1] == array[i] ){
                end_idx = i;
            }else{
                start_idx = i;
            }
            if(start_idx<end_idx) {
                map.put(end_idx - start_idx, new Integer[]{array[start_idx], array[end_idx]});
                max_pq.add(end_idx - start_idx);

            }
        }//for
        Integer[] result = map.get(max_pq.poll());
        return new int[]{result[0], result[1]};
    }

    //https://www.algoexpert.io/questions/Largest%20Range
    public static int[] largestRange2(int[] array) {
        // Write your code here.
        int max1 = 0;
        int max2 = 0;
        int temp1= 0;
        int temp2= 0;
        int x= 0;
        int y= 0;
        HashMap<Integer, XY> rangeOfXYMap = new HashMap<>();
        for(int i=0; i<array.length; i++){
            for(int j=1; j<array.length; j++){
                if(max1>max2){
                    max2 = max1;

                }
                temp1 = array[i]-array[j];
                temp2 = array[j]-array[i];
                XY xy = null;
                if(temp1>temp2){
                    xy = new XY(array[j], array[i]);
                    max1 = temp1;
                }else{
                    xy = new XY(array[i], array[j]);
                    max1 = temp2;
                }

                rangeOfXYMap.put(max1, xy);
            }//for
            if(i==array.length-1){

            }
        }//for
        max1 = max1>max2 ? max1 : max2;
        int[] result = {rangeOfXYMap.get(max1).x, rangeOfXYMap.get(max1).y};
        return result;
    }
}
