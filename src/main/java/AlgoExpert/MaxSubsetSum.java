package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.algoexpert.io/questions/Max%20Subset%20Sum%20No%20Adjacent
public class MaxSubsetSum {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        int[] array = {75, 105, 120, 75, 90, 135};
        int result =  maxSubsetSumNoAdjacent(array);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] newArray = new int[array.length];


        for(int i=0; i<array.length; i++){
            if(i==0){
                newArray[i] = array[i];
            }else if(i==1){
                newArray[i] = Math.max(array[0], array[1]);
            }else{

                newArray[i] = Math.max(newArray[i-1], (newArray[i-2]+array[i]));
            }
        }
        return newArray[array.length-1];
  }

}
