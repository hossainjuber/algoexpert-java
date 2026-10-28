package AlgoExpert;

import java.util.*;

public class RemoveIslands {
        /*
		1. iterate over the matrix
		2. if 1 is encountered then search for adjacent 1s to
		ge the full structure, at each progression check to see if
		edge of matrix is hit with 1 if yes then it not an island.
		In order to optimize the algo, lets put all non islands into a
		set.  we will consult this set once a 1 in found.
		3. if island is found, copy all the coordinates into a map and
		hand it over to another method, which will erase the island.
		*/
   public static void main(String[] args){
       int[][] matirx = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
       };
        //removeIslands(matirx);
   }

   public int[][] removeIslands(int[][] matrix) {
           boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];
           for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++) {
                    onesConnectedToBorder[i][matrix[0].length - 1] = false;
                }
           }
           boolean isRowBorder = false;
           boolean isColBorder = false;
           boolean onTheBorder = false;
           for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++) {
                    isRowBorder = i==0 || i==matrix.length-1;
                    isColBorder = j==0 || j==matrix[i].length-1;
                    onTheBorder = isRowBorder || isColBorder;

                    if(!onTheBorder || matrix[i][j]==0) continue;

                    //if I reached this line then this means my current
                    //cell is on the border and value is 1.
                    findOnesConnectedToBorder(matrix, i, j, onesConnectedToBorder);

                }//for
           }//for
            for(int i=0; i<matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(onesConnectedToBorder[i][j]) continue;
                    matrix[i][j]=0;
                }
            }
           return matrix;
       }

     public static void findOnesConnectedToBorder(int[][] matrix, int row, int col, boolean[][] onesConnectedToBorder){
         Stack<int[]> stack = new Stack<>();
         stack.push(new int[] {row, col});

         while(!stack.isEmpty()){
             int[] coordinates = stack.pop();
             int currentRow = coordinates[0];
             int currentCol = coordinates[1];
             boolean alredyVisited = onesConnectedToBorder[currentRow][currentCol];

             if(alredyVisited){
                 continue;
             }else{
                 onesConnectedToBorder[currentRow][currentCol] = true;
             }
             int[][] neighbors = getNeighbors(currentRow, currentCol, matrix);
             for(int[] neighbor:  neighbors){
                 int r = neighbor[0];
                 int c = neighbor[1];
                 if(matrix[r][c]==0)continue;
                 stack.push(neighbor);
             }
         }//while
     }

     public static int[][] getNeighbors(int row, int col, int[][] matrix){
        ArrayList<int[]> allNeighbors = new ArrayList<>();
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;

        if(row-1 >=0){
            allNeighbors.add(new int[]{row-1, col});
        }

        if(col-1 >=0){
            allNeighbors.add(new int[]{row, col-1});
        }

        if(row+1 <=matrix.length){
            allNeighbors.add(new int[]{row+1, col});
        }

        if(col+1 <matrix[0].length){
            allNeighbors.add(new int[]{row, col+1});
        }

        int[][] neighbors = new int[allNeighbors.size()][2];
        for(int i=0; i<allNeighbors.size(); i++){
            neighbors[i]=allNeighbors.get(i);
        }
        return neighbors;
     }

     public static void print(boolean[][] matrix){
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
