package AlgoExpert;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
/*
* 1. Identify the substring in a list with beginning index and end index
* 2. collapse the indexes into a single pair of beginning and end index
* 3. iterate of this collapsed index list and write it out into a StringBuilder
* */
public class SweetAndSavory {

    public static void main(String[] str){
        int[] dishes = new int[]{-3,-5,1,7};
        int combinedDish = 8;
        int[] result = sweetAndSavory(dishes, combinedDish);
    }

    public static class SS{
        int sweet;
        int savory;
        SS(int sweet, int savory){
            this.sweet = sweet;
            this.savory = savory;
        }
    }

    public static int[] sweetAndSavory(int[] dishes, int target) {
        Arrays.sort(dishes);
        List<Integer> sweet = new ArrayList<>();
        List<Integer> savory = new ArrayList<>();
        getSweetAndSavory(dishes, sweet, savory);
        int i = 0;
        int j = savory.size()-1;
        int result1 = 0;
        int result2 = Integer.MAX_VALUE;
        Stack<SS> stack = new Stack<>();
        while(i<sweet.size() && j>=0){
            result1 = sweet.get(i) + savory.get(j);

            if(result1<result2 && result1>0){
                result2 = result1;
                if(!stack.isEmpty()){
                    stack.pop();
                    stack.push(new SS(i,j));
                }
            }
            i++;
            j--;
        }//while
        SS ss1 = stack.pop();
        return i>j ? new int[] {j, i}: new int[]{i, j};
    }

    public static void getSweetAndSavory(int[] array, List<Integer> sweet, List<Integer> savory){

        for(int i=0; i<array.length; i++){
            if(array[i]<0){
                sweet.add(array[i]);
            }else{
                savory.add(array[i]);
            }
        }//for
    }



}
