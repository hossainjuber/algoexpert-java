package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareOfZeros2 {
    /*
    Square of Zeros:
    Write a function in JAVA using dynamic programming that takes in a square-shaped n x n
    two-diminsional array of only 1s
    and 0s and returns a boolean representing whether the input matrix contains a square
    whose borders are made up of only 0s.

    Please use the following method signature for the main method:
    public static boolean squareOfZeroes(List<List<Integer>> matrix)

    Note that a 1 x 1 square doesn't count as a valid square for the purpose of this
    question.  In other words, a sungualr 0 in the input matrix doesn't constitute a
    square whose border are make up on only os, a square of zeros has to be at least 2 x 2
    */
   public static void main(String[] args){

	/*List<List<Integer>> matrix = new ArrayList<>();
	List<Integer> l1 = Arrays.asList(1, 1, 0, 1);
	List<Integer> l2 = Arrays.asList(1, 0, 0, 1);
	List<Integer> l3 = Arrays.asList(0, 0, 0, 1);
	List<Integer> l4 = Arrays.asList(1, 1, 1, 1);
	matrix.add(l1);
	matrix.add(l2);
	matrix.add(l3);
	matrix.add(l4);*/
	List<List<Integer>> matrix = new ArrayList<>();
	List<Integer> l1 = Arrays.asList(1, 1, 1, 0, 1, 0);
	List<Integer> l2 = Arrays.asList(0, 0, 0, 0, 0, 1);
	List<Integer> l3 = Arrays.asList(0, 1, 1, 1, 0, 1);
	List<Integer> l4 = Arrays.asList(0, 0, 0, 1, 0, 1);
	List<Integer> l5 = Arrays.asList(0, 1, 1, 1, 0, 1);
	List<Integer> l6 = Arrays.asList(0, 0, 0, 0, 0, 1);
	matrix.add(l1);
	matrix.add(l2);
	matrix.add(l3);
	matrix.add(l4);
	matrix.add(l5);
	matrix.add(l6);

    squareOfZeroes(matrix);
   }

    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        List<List<Coordinate>> cache = new ArrayList<>();


        for (int i = 0; i < matrix.size(); i++) {
            List<Coordinate> currentRow = new ArrayList<>();

            // Step 3: Populate the inner list with Coordinate objects
            for (int j = 0; j < matrix.get(i).size(); j++) {
                currentRow.add(new Coordinate(0, 0));
            }

            // Step 4: Add the finished inner list to the outer list
            cache.add(currentRow);
        }

        int i = matrix.size()-1;
        int j = matrix.get(i).size()-1;
        int lastValue = matrix.get(i).get(j);
        if(lastValue==0){
            lastValue = 1;
        }

        int coordinateBelow_y_value = 0;
        for(i=matrix.size()-1; i>0; i--){
            for(j=matrix.get(i).size()-1; j>0; j--){
                if(matrix.get(i).get(j)==1){
                    Coordinate coordinate = new Coordinate(0,0);
                    cache.get(i).set(j, coordinate);
                }else if (matrix.get(i).get(j)==0) {
                    Coordinate coordinateToRight = null;
                    if(j==matrix.get(i).size()-1){
                        coordinateToRight = cache.get(i).get(j);
                    }else{
                        coordinateToRight = cache.get(i).get(j + 1);
                    }

                    coordinateBelow_y_value = 1;
                    Coordinate coordinateBelow = null;
                    if (i < matrix.size() - 2) {
                        coordinateBelow = cache.get(i - 1).get(j);
                        coordinateBelow_y_value = coordinateBelow.y;
                    }

                    Coordinate newCoordinateValue = new Coordinate(coordinateToRight.x + 1,
                            coordinateBelow_y_value + 1);
                    cache.get(i).set(j, newCoordinateValue);
                    if (newCoordinateValue.x == newCoordinateValue.y && i < matrix.size() - 2) {
                        return true;
                    }
                }//else if

            }//for
        }//for
        return false;

    }

    static class Coordinate{
        Coordinate(int xx, int yy){
            x=xx;
            y=yy;
        }
        int x;
        int y;
    }


}
