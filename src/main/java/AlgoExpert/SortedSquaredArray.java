package AlgoExpert;

//https://www.algoexpert.io/questions/Two%20Number%20Sum

/*
* Given an array with positive and negative numbers return the sorted squared version of it
* */

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args){
        int[] array = {3, 5, -4, 8, 0, 1, -1, 6 };
        int[] result = getSortedSquaredArray(array);

        System.out.println("Here is the soreted squred array: " + Arrays.toString(result));
        System.out.println("The End");
    }

    public static int[] getSortedSquaredArray(int[] array){
        for(int i=0; i<array.length; i++){
            array[i] = array[i] * array[i];
        }
        Arrays.sort(array);
        return array;
    }


}
