package AlgoExpert;

public class searchInSortedMatrix {
    public static void main(String[] str){
        int[] r1 = {1, 4, 7, 12, 15, 1000};
        int[] r2 = {2, 5, 19, 31, 32, 1001};
        int[] r3 = {3, 8, 24, 33, 35, 1002};
        int[] r4 = {40, 41, 42, 44, 45, 1003};
        int[] r5 = {99, 100, 103, 106, 128, 1004};
        int[][] container = {r1, r2, r3, r4, r5};
        searchInSortedMatrix(container, 1004);
    }

      public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    // Write your code here.
		int col=0;
		for(int i=matrix[0].length-1; i>=0; i--){
			if(matrix[0][i]<=target){
				col=i;
				break;
			}//if
		}//for
		int row=0;
		for(int j=matrix.length-1; j>=0; j--){
			if(matrix[j][0]<=target){
				row=j;
				break;
			}//if
		}//for
		int[] result = new int[] {-1, -1};
		//new int[] {-1, -1};
		for(int k=0; k<matrix.length; k++){
			if(matrix[k][col]==target){
				result[0] = k;
				result[1] = col;
				return result;
			}
		}

		for(int m=0; m<matrix[0].length; m++){
			if(matrix[row][m]==target){
				result[0] = row;
				result[1] = m;
				return result;
			}
		}

    return result;
  }
}
