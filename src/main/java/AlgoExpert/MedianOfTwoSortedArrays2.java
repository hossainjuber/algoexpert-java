package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//AlgoExpert/MedianOfTwoSortedArrays.java
public class MedianOfTwoSortedArrays2 {

    public static void main(String[] str){
        /*int[] arrayOne = {1,3,4,5, 7, 9};
        int[] arrayTwo = {0,1,2,2,4};
        int[] arrayOne = {6,7,8,9};
        int[] arrayTwo = {1,3,4,5};

        int[] arrayOne = {1};
        int[] arrayTwo = {2,3};

        int[] arrayOne = {1,3,4};
        int[] arrayTwo = {2,3,6};*/

        int[] arrayOne = {1,3,4,5};
        int[] arrayTwo = {6,7,8,9};

        /*int[] arrayOne = {1,3,4,5};
        int[] arrayTwo = {2,3,6,7};*/

        float result = medianOfTwoSortedArrays(arrayOne, arrayTwo);
            System.out.println("Result: " + result);
    }
    public static float medianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int totalLength = arrayOne.length + arrayTwo.length;
        int mid = totalLength / 2;
        int one = 0;
        int two = 0;
        while(one+two<mid && one<arrayOne.length-1 && two<arrayTwo.length-1){
            if(arrayOne[one]<arrayTwo[two]){
                one++;
            }else if(arrayOne[one] > arrayTwo[two]) {
                two++;
            }else if(arrayOne[one]==arrayTwo[two]){
                one++;
                two++;
            }
        }//while
        if(totalLength%2==0){
            return (float) ((arrayOne[one] + arrayTwo[two])/2.0);
        }else{
            return Math.min(arrayOne[one], arrayTwo[two]);
        }

    }

}
