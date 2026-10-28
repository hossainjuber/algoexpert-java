package AlgoExpert;

import java.util.Arrays;
import java.util.HashMap;

public class LargestChronologicalRange2 {

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

        HashMap<Integer, Boolean> tracker = new HashMap<>();
        for(int i=0; i<array.length; i++){
            if(tracker.get(array[i])==null){
                tracker.put(array[i], false);
            }
        }
        int[] r1 = {0, 0};
        int [] r2 = {0, 0};
        int head = 0;
        int tail = 0;
        int n=0;
        int m=0;
        for(int i=0; i<array.length; i++){
            if(!tracker.get(array[i])){
                n=array[i];
                m=array[i];
                head=array[i];
                while(tracker.get(n-1)!=null ){
                    tracker.put(n-1, true);
                    head = array[n]-1;
                    n--;
                }
                tail = array[i];
                while(tracker.get(m+1)!=null ){
                    tracker.put(m+1, true);
                    tail = array[m]+1;
                    m++;
                }
                r1 = new int[]{head, tail};
                /*if(head>tail){
                    r1 = new int[]{tail, head};
                }else{
                    r1 = new int[]{head, tail};
                }*/
                if(r1[1]-r1[0] > r2[1]-r2[0]){
                    r2 = new int[]{r1[0], r1[1]};
                }
            }//if
        }//for
        int[] result = new int[]{};
        return result;
    }
}
