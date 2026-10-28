package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RiverSizes2 {
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
        print(matrix);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        /*
         * 1. iterate over the entire matrix
         * 2. have an extra tracker matrix of the same size with boolean values
         * 3. have a crawler method that goes top, bottom, left and right once a 1 is encountered.
         * 4. the crawler method will constantly update the extra tracker matrix
         * */
        boolean[][] tracker = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        int river_size = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (tracker[i][j]) {
                    continue;
                } else {
                    crawl(matrix, tracker, result, i, j);
                }
            }
        }

        return result;
    }//riverSizes

    public static void crawl(int[][] matrix, boolean[][] tracker, List<Integer> list, int x, int y) {
        Stack<X_Y> stack = new Stack<>();
        int riverSize =0;
        stack.push(new X_Y(x, y));
        X_Y x_y = null;
        while(!stack.isEmpty()){
            x_y = stack.pop();
            if(matrix[x_y.x][x_y.y]==0) continue;

            tracker[x_y.x][x_y.y]=true;
            if(matrix[x_y.x][x_y.y]==0) continue;
            riverSize++;
            //get Neighbors
            List<X_Y> neighbors = getNeighbors(matrix, tracker, x, y);
            for(X_Y neighbor : neighbors){
                stack.push(new X_Y(neighbor.x, neighbor.y));
            }

        }//while
        if(riverSize>0) list.add(riverSize);

    }//crawl

    public static List<X_Y> getNeighbors(int[][] matrix, boolean[][] tracker, int x, int y){
        List<X_Y> neighbors = new ArrayList<>();
        if(x-1>=0 && !tracker[x-1][y] && matrix[x-1][y]==1){
            neighbors.add(new X_Y(x-1, y));
        }
        if(x+1<matrix.length && !tracker[x+1][y] && matrix[x+1][y]==1){
            neighbors.add(new X_Y(x+1, y));
        }
        if(y-1>=0 && !tracker[x][y-1] && matrix[x][y-1]==1){
            neighbors.add(new X_Y(x, y-1));
        }
        if(y+1<matrix[0].length && !tracker[x][y+1] && matrix[x][y+1]==1){
            neighbors.add(new X_Y(x, y+1));
        }
        return neighbors;
    }

    public static void print(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(" " + matrix[i][j] + " ");
            }
            System.out.println(sb.toString());
            sb = new StringBuffer();
        }
        System.out.println("***************");
    }

    public static class X_Y{
        int x;
        int y;
        public X_Y(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}

