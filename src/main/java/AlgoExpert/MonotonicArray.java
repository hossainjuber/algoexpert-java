package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.algoexpert.io/questions/Three%20Number%20Sum
public class MonotonicArray {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        //int[] array = {12,3,1,2,-6,5,-8,6};
        //int targetSum = 0;
        //int[] array = {1, 2, 3};
        //int targetSum = 6;
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        boolean result = isMonotonic(array);
        System.out.println("The End");
    }

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        //base case;
        if(array.length==0 || array.length==1 || array.length==2) return true;

        boolean increasing = true;
        int i = 0;
        int j = 1;
        while(array[i]==array[j] && i<array.length && j<array.length){
            i++;
            j++;
        }

        if(j>=array.length-1){
            return true;
        }

        if(array[i] > array[j]){
            increasing = false;
        }
        i++;
        while(i<=array.length-1){

            /*if(array[i]==array[i-1]){i++;
                return false;
            }else if(increasing && array[i]>array[i-1]){i++;
                continue;
            }else if(!increasing && array[i]<array[i-1]){i++;
                continue;
            }else */
            if(array[i]==array[i-1]){
                return true;
            }else if(increasing && array[i]<array[i-1]){
                return true;
            }else if(!increasing && array[i]>array[i-1]){
                return true;
            }
            i++;
        }
        return false;
    }


}
