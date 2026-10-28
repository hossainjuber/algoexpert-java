package AlgoExpert;

public class numberOfWaysToTraversAGraph {

    public static void main(String[] args){
        //int numOfWays = numberOfWaysToTraverseGraph(2, 3);
        int numOfWays = numberOfWaysToTraverseGraph(4, 3);
        System.out.println("The End");
   }

    public static int numberOfWaysToTraverseGraph(int width, int height) {
    /*
		1. mark the borders with 1
		2. iterate over the remaining cells and for each mark it with
		sum of top and left cell values
		3. once right corner is reached return teh total
		*/

        int rows = height;
        int col = width;

        int[][] matrix = new int[width][height];

        for(int i=0; i<matrix.length; i++){
            matrix[i][0] = 1;
        }
        for(int j=0; j<matrix[0].length; j++){
            matrix[0][j] = 1;
        }

        for(int k=1; k<matrix.length; k++){
            for(int m=1; m<matrix[0].length; m++){
                matrix[k][m] = matrix[k-1][m] + matrix[k][m-1];
            }//for
        }//for

        return matrix[col-1][rows-1];
    }

}
