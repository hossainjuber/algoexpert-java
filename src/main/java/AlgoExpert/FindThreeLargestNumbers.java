package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://www.algoexpert.io/questions/Find%20Three%20Largest%20Numbers
//Time Complesxity: O( n * m)
//Space Complexity: O(n)
public class FindThreeLargestNumbers {

   public static void main(String[] args){

       //int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
       int[] array = {55, 7, 8};
       findThreeLargestNumbers(array);

   }

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        if(array==null || array.length<3) return array;
        int[] result = new int[3];
        int temp = 0;
        int temp2 = 0;
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        result[2] = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<=3; j++){
                if(result[2]<=array[i]){
                    temp = result[2];
                    result[2] = array[i];
                    if(temp>=result[1]){
                        temp2 = result[1];
                        result[1] = temp;
                    }
                    if(temp2>=result[0]){
                        result[0] = temp2;
                    }
                    break;
                }else if(result[1]<=array[i]){
                    temp = result[1];
                    result[1] = array[i];
                    if(temp>result[0]){
                        result[0]= temp;
                    }
                    break;
                }else if(result[0]<array[i]){
                    result[0] = array[i];
                }
            }//for
        }//for
        return result;
    }


}
