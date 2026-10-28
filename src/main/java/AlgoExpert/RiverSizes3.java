package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RiverSizes3 {
    public static void main(String[] str) {
        /*int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };*/
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        riverSizes(matrix);
        //print(matrix);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        /*
        * 1. Create a tracker/memory array equal to the size of the passed in array and initialize all cells to false
        * 2. Use BFS, algo, use a queue to traverse over this matrix
        * 3. if current cell is a 1 then call a fan out method that will fan out to look for neighbors with value of 1
        * 4. enqueue the list returned from this fan out array and keep dequeuing from the queue (using a while) loop
        * 5. towards
        * tm = trackerMatrix
        * */

        List<Integer> result = new ArrayList<>();
        boolean[][] tm = new boolean[matrix.length][matrix[0].length];
        initializeMatrix(tm);

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(tm[i][j]){
                    continue;
                }else {
                    int riverSize = fanout(matrix, tm, i, j);
                    if(riverSize>0) {
                        result.add(riverSize);
                    }
                }
            }//for
        }//for

        return result;
    }

    public static int fanout(int[][] matrix, boolean[][] tm, int i, int j){
        int riverSize = 0;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{i, j});

        while(!stack.isEmpty()){
            Integer[] xy = stack.pop();
            int x = xy[0];
            int y = xy[1];
            if(tm[x][y]) {
                continue;
            }
            tm[x][y] = true;
            if(matrix[x][y]==0){
                continue;
            }
            riverSize++;
            List<Integer[]> neighbors = new ArrayList<>();
            getNeighbors(x, y, matrix, tm, neighbors);
            for(Integer[] pair: neighbors){
                stack.push(pair);
            }
        }//while
        return riverSize;
    }


    public static void getNeighbors(int x, int y, int[][] matrix, boolean[][] tm, List<Integer[]> neighbors){
        if(x-1>=0 && tm[x-1][y]!=true && matrix[x-1][y]==1){
            neighbors.add(new Integer[]{x-1, y});
        }if(y-1>=0 && tm[x][y-1]!=true && matrix[x][y-1]==1){
            neighbors.add(new Integer[]{x, y-1});
        }if(x+1<matrix[0].length && tm[x+1][y]!=true && matrix[x+1][y]==1){
            neighbors.add(new Integer[]{x+1, y});
        }if(y+1<matrix.length && tm[x][y+1]!=true && matrix[x][y+1]==1){
            neighbors.add(new Integer[]{x, y+1});
        }
    }


    public static void initializeMatrix(boolean[][] tm){
        for(int i=0; i<tm.length; i++){
            for(int j=0; j<tm[0].length; j++){
                tm[i][j] = false;
            }//for
        }//for
    }

}

