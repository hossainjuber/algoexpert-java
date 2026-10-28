package AlgoExpert;

public class LevenshteinDistance {
    public static void main(String[] str){
        String str1 = "abc";
        String str2 = "yabd";
        levenshteinDistance(str1, str2);

        /*String[][] matrix = {{"a", "b", "c"},{"d", "e", "f"},{"g","h","i"}};
        StringBuffer sb = null;
        for(int i=0; i<matrix.length; i++){
        	sb = new StringBuffer();
        	for(int j=0; j<matrix[i].length; j++){
        		sb.append(matrix[i][j]);
			}
			System.out.println(sb.toString());
		}*/
    }
    public static int levenshteinDistance(String str1, String str2) {
    // Write your code here.
		int[][] matrix = new int[str1.length()+1][str2.length()+1];
		//imagine we have extra top most row witn str2
		//and we have extra left most column with str1

		String[] colLabel = new String[str2.length()+1];
		colLabel[0] = "";
		for(int x=1; x<=str2.length(); x++){
			colLabel[x] = String.valueOf(str2.charAt(x-1));
		}
		String[] rowLabel = new String[str1.length()+1];
		rowLabel[0] = "";
		for(int y=1; y<=str1.length(); y++){
			rowLabel[y] = String.valueOf(str1.charAt(y-1));
		}

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(i==0){
					matrix[i][j]=j;
				}else if(j==0){
					matrix[i][j]=i;
				}else{
					continue;
				}
			}
		}
		int min=0;
		for(int row=1; row<matrix.length; row++){
			for(int col=1; col<matrix[row].length; col++){
				if(colLabel[col].equals(rowLabel[row])){
					matrix[row][col] = matrix[row-1][col-1];
				}else{
					min = Math.min(matrix[row-1][col], matrix[row][col-1]);
					min = Math.min(min, matrix[row-1][col-1]);
					matrix[row][col] = 1 + min;
				}
		  }
		}

    return matrix[matrix.length-1][matrix[0].length-1];
  }
}
