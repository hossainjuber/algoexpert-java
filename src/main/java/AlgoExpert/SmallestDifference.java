package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class SmallestDifference {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        int[] array1 = {-1, 5, 10, 20, 28, 3};
        int[] array2 = {26, 134, 135, 15, 17};
        int[] result = smallestDifference(array1, array2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getSmallestDiff(int[] arr1, int[] arr2){
        int[] result = new int[2];
        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                diff1 = Math.abs(arr1[i] - arr2[j]);
                if(diff1<diff2){
                    diff2 = diff1;
                    result[0] = arr1[i];
                    result[1] = arr2[j];
                }
            }
        }
        return result;
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		int diff1 = Integer.MAX_VALUE;
		int diff2 = Integer.MAX_VALUE;
		int[] result = new int[2];
		for(int i=0; i<arrayOne.length; i++){
			for(int j=0; j<arrayTwo.length; j++){
			    diff1 = Math.abs(arrayOne[i]-arrayTwo[j]);
                if(diff1<diff2){
                    diff2 = diff1;
                    result[0] = arrayOne[i];
                    result[1] = arrayTwo[j];
                }

			}
		}

    return result;
  }
}
