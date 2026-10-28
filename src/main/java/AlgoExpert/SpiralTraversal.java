package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Spiral%20Traverse
public class SpiralTraversal {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        //int[] array = {12,3,1,2,-6,5,-8,6};
        //int targetSum = 0;
        //int[] array = {1, 2, 3};
        //int targetSum = 6;
        /*int[][] array = new int[][]{
            {1,   2,  3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10,  9,  8, 7}
        };*/
        int[][] array = new int[][]{
            {1,  2,  3, 4},
            {10, 11, 12, 5},
            {9, 8, 7,  6}
        };

        List<Integer> result = spiralTraverse(array);
        System.out.println("The End");

        for(Integer num : result){
            System.out.println(num);
        }
    }


    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length-1;
        int startCol = 0;
        int endCol = array[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int y=startCol; y<=endCol; y++){
                list.add(array[startRow][y]);
            }

            for(int x=startRow+1; x<=endRow; x++){
                list.add(array[x][endCol]);
            }

            for(int y=endCol-1; y>startCol; y--){
                list.add(array[endRow][y]);
            }

            for(int x=endRow-1; x>startRow; x--){
                list.add(array[x][startCol]);
            }
            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }//while
        return list;
    }


}
