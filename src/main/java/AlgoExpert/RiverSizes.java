package AlgoExpert;

import java.util.*;

class RiverSizes {
    public static void main(String[] str){
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        riverSizes(matrix);
        //print(matrix);
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

    public static ArrayList<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        boolean[][] tracker = new boolean[matrix.length][matrix[0].length];
        int counter = 1;
        int x;
        int y;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                crawler(matrix, tracker, i, j,  list);
            }
        }

        System.out.println("size: " + list.size());
        return null;
    }

    public static void crawler(int[][] matrix, boolean[][] tracker, int x, int y, ArrayList<Integer> list) {
        Stack<XY> stack = new Stack<>();
        stack.push(new XY(x, y));
        XY xy;
        int riverSize = 0;
        while(!stack.isEmpty()){
            xy = stack.pop();
            if(tracker[xy.x][xy.y]){
                continue;
            }
            tracker[xy.x][xy.y]=true;
            if(matrix[xy.x][xy.y]==0){
                continue;
            }
            riverSize++;
            ArrayList<XY> neighbores = getNeighbors(matrix, tracker, xy.x, xy.y);
            for(XY x_y : neighbores){
                stack.push(x_y);
            }
        }
        if(riverSize>0){
            list.add(riverSize);
        }
    }

    public static ArrayList<XY> getNeighbors(int[][] matrix, boolean[][] tracker, int x, int y){
        ArrayList<XY> resultList = new ArrayList<>();
        if(x>0 && !tracker[x-1][y]){
            resultList.add(new XY(x-1, y));
        }
        if(x<matrix.length-1 && !tracker[x+1][y]){
            resultList.add(new XY(x+1, y));
        }
        if(y>0 && !tracker[x][y-1]){
            resultList.add(new XY(x, y-1));
        }
        if(y<matrix[0].length-1 && !tracker[x][y+1]){
            resultList.add(new XY(x, y+1));
        }

        return resultList;
    }

    public static class XY{
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }
}



    /*public static int crawler(int counter, int[][] matrix, boolean[][] tracker, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length - 1 || y >= matrix[0].length - 1 || tracker[x][y] || matrix[x][y] == 0) {
            return counter;
        }
        if (!tracker[x][y]) {
            tracker[x][y] = true;
        }

        return crawler(counter, matrix, tracker, x + 1, y) + crawler(counter, matrix, tracker, x, y + 1) +
                    crawler(counter, matrix, tracker, x - 1, y) + crawler(counter, matrix, tracker, x, y - 1);
    }*/

