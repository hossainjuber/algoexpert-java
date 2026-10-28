package AlgoExpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LargestChronologicalRange {

    public static void main(String[] str){
        //int[] range = {5, 1, 2, 3, 0, -5};
        //int[] range = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] range = {19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14};
        int[] result = LargestChronologicalRange(range);
        //System.out.println(result[0]);
        //System.out.println(result[1]);
    }

    public static class XY{
        int x;
        int y;
        public XY(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    //https://www.algoexpert.io/questions/Largest%20Range
    public static int[] LargestChronologicalRange(int[] array) {
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<array.length; i++){
            sb.append(", "+String.valueOf(array[i])+" ");
        }
        //System.out.println(sb.toString());
        int s1 = 0;
        int e1 = 0;
        int s2 = 0;
        int e2 = 0;
        int counter1 = 0;
        int counter2 = 0;
        for(int i=1; i<array.length; i++){
            if(array[i-1]==array[i]){
                continue;
            }else if(array[i-1]+1 == array[i]){
                counter1++;
                e1 = i;
            }else{
                e1=i-1;
                if(counter1>counter2){
                    s2 = s1;
                    e2 = e1;
                    counter2=counter1;
                }
                s1 = i;
                e1 = 0;
                counter1=0;
            }
        }
        int[] result = {};
        if(counter1>counter2){
            result = new int[]{array[s1], array[e1]};
        }else{
            result = new int[]{array[s2], array[e2]};
        }
        return result;
    }
}
