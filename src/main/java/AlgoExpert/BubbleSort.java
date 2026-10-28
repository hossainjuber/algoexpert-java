package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
//https://www.algoexpert.io/questions/Branch%20Sums
//Time complexity: O(n*m)
//Space complexity: O(1)
public class BubbleSort {

   public static void main(String[] args) {
       int[] array = {8, 5, 2, 9, 5, 6, 3};
       bubbleSort(array);
   }

    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        int temp = 0;
        int k = array.length;
        int p1 = 0;
        int p2 = 1;

        for(int i=array.length; i>=0; i--) {
            p1 = 0;
            p2 = 1;
            while(p2 < i){
                if(array[p1]>array[p2]){
                    temp = array[p1];
                    array[p1] = array[p2];
                    array[p2] = temp;
                }
                p1++;
                p2++;

            }//while

        }//for

        return array;
    }

}
