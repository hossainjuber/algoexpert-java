package AlgoExpert;

import java.util.ArrayList;
import java.util.Stack;

class RiverSizesRecursive {
    public static void main(String[] str){
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        boolean[][] tracker = new boolean[matrix.length][matrix[0].length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                tracker[i][j]=false;
            }
        }

        int size = crawler(0, matrix, tracker, 0, 1, list);
        System.out.println("The End");
    }

    public static int crawler(int counter, int[][] matrix, boolean[][] tracker, int x, int y, ArrayList<Integer> list) {
        if(x-1<0 || y-1<0 || x+1>matrix.length || y+1>matrix[0].length || tracker[x][y] || matrix[x][y]==0 ){
            return 0;
        }

        return crawler(1, matrix, tracker, x+1, y, list) +
                crawler(1, matrix, tracker, x-1, y, list) +
                crawler(1, matrix, tracker, x, y-1, list) +
                crawler(1, matrix, tracker, x, y+1, list);
    }

    public static void print(int[][] matrix){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                sb.append(" "+matrix[i][j]+" ");
            }
            System.out.println(sb.toString());
            sb = new StringBuffer();
        }
        System.out.println("***************");
    }
}




