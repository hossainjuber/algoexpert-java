package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Spiral%20Traverse
public class SpiralTraversalRecursive {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        //int[] array = {12,3,1,2,-6,5,-8,6};
        //int targetSum = 0;
        //int[] array = {1, 2, 3};
        //int targetSum = 6;
        int[][] array = new int[][]{
            {1,   2,  3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10,  9,  8, 7}
        };
        int startRow = 0;
        int endRow = array.length-1;
        int startCol = 0;
        int endCol = array[0].length-1;
        List<Integer> list = new ArrayList<>();
        List<Integer> result = spiralTraverse(array, list, startRow, endRow, startCol, endCol);
        System.out.println("The End");
    }

    public static List<Integer> spiralTraverse(int[][] array, List<Integer> list, int startRow, int endRow, int startCol, int endCol){
        if(startRow > endRow || startCol > endCol) return list;

        for(int y=startCol; y<=endCol; y++){
                list.add(array[startRow][y]);
        }

        for(int x=startRow+1; x<=endRow; x++){
            list.add(array[x][endCol]);
        }

        for(int y=endCol-1; y>=startCol; y--){
            list.add(array[endRow][y]);
        }

        for(int x=endRow+1; x<=startRow+1; x--){
            list.add(array[x][startCol]);
        }
        startRow=startRow+1;
        endRow=endRow-1;
        startCol = startCol+1;
        endCol=endCol-1;
        return spiralTraverse(array, list, startRow, endRow, startCol, endCol);
    }




}
