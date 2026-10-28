package AlgoExpert;

import java.util.ArrayList;
import java.util.Stack;
/*
* You are given an integer array nums. You are initially positioned at the array's first index,
*  and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
*
* [1, 1, 0, 0, 1, 0]
* 1. Iterate over the input array and at each position make a decison
* 2. if current iteration value is zero return false
* 3. if current iteration value is greater than array length return true
* 4. if current iteration value is less than array length, go to that index and continue
* */
public class Hopper {

    public static void main(String[] str) {
        int[] array = {1, 2, 1, 3, 9};
        if(hopper(array)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }

    public static boolean hopper(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int position = array[0];
        //for (int i = 0; i < array.length; i++) {
        int i = 0;
        while(i<array.length){
            position = array[i];
            //case # 1
            if (position == 0) {
                return false;
            }//case # 2
            else if (position > array.length - i) {
                return true;
            }//case # 3
            i = i + array[i];
            if(i>array.length-1) return true;

        }//for

        return false;
    }
}
