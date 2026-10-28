package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {

    private static Object state;

    public static void main(String[]  args){
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        l1.add(4);
        l1.add(10);
        matrix.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(5);
        l2.add(9);
        l2.add(11);
        matrix.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(8);
        l3.add(12);
        l3.add(15);
        matrix.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(7);
        l4.add(13);
        l4.add(14);
        l4.add(16);
        matrix.add(l4);

        //printMatrix(matrix);
        zigzagTraverse(matrix);
    }

    /*
    * 1. If col = 0 || col=length-1 -> VERTICAL_DOWN
    * 2. VERTICAL_DOWN is always one row down
    * 3. VERTICAL_DOWN (if col==0) is always followed by DIAG_UP
    * 4. VERTICAL_DOWN (if col==last column) is always followed by DIAG_DOWN
    * 5. DIAG_UP|DIAG_DOWN is always followd by horizontal right (one col)
    * */
    public static List<Integer> zigzagTraverse(List<List<Integer>> matrix) {

        List<Integer> result = new ArrayList<>();
        int height = matrix.size()-1;
        int width = matrix.get(0).size()-1;
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        while(!crossingBoundaries(row, height, col, width)){
            result.add(matrix.get(row).get(col));
            if(goingDown){
                if(col==0 || row==height){
                    goingDown=false;
                    if(row==height){
                        col++;
                    }else{
                        row++;
                    }
                }else{
                    col--;
                    row++;
                }
            }else{
                if(row==0 || col==width){
                    goingDown=true;
                    if(col==width){
                        row++;
                    }else{
                        col++;
                    }
                }else{
                    row--;
                    col++;
                }
            }
        }
        return result;

    }

    public static boolean crossingBoundaries(int row, int height, int col, int width){
        return row<0 || row>height || col<0 || col>width;
    }

    public static void printMatrix(List<List<Integer>> matrix){
        List<Integer> innerList = null;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<matrix.size(); i++){
            innerList = matrix.get(i);
            for(int j=0; j<innerList.size(); j++) {
                sb.append(" | "+String.valueOf(innerList.get(j)));
            }
            System.out.println(sb.toString());
            sb = new StringBuffer();
        }

    }



}
