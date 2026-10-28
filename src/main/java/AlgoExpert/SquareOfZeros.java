package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareOfZeros {

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
		List<Integer> list = null;
		int length = matrix.size();
		int width_counter = 0;
		boolean potential_sq=false;
		int vertical_counter = 0;
		boolean col_start = false;
    	for(int i=0; i<matrix.size(); i++){
			list = matrix.get(i);
			int j_copy;
			width_counter=1;
			for(int j=1; j<list.size(); j++){
				j_copy = j-1;
				if(list.get(j-1)==0 && list.get(j)==0){
					col_start=true;
					if(col_start) {
						j_copy = j-1;
						col_start=false;
					}
					width_counter++;
					potential_sq=true;
					continue;
				}

				if(potential_sq){
					boolean found = squareFound(matrix, i, width_counter, j_copy);
					if(found) return true;
				}

			}//for
		}//for
    	return false;
  }

    public static boolean squareFound(List<List<Integer>> matrix, int x, int width, int y) {
   		List<Integer> inner_list = null;
   		int layer = matrix.size()/2;
   		int k=0;
		//for(int i=0; i<matrix.size(); i++){
		int row=0;
		int col=0;
		int row_start=x;
		//int row_end=matrix.size()-1;
		int row_end=width;
		int col_start=width-y;
		//int col_end=matrix.size()-1;
		int col_end=y;

		while (k<=layer){
			/*inner_list = matrix.get(row_start);
			for(int j=col_start; j<=col_end; j++){
				if(inner_list.get(j)==1) return false;
				System.out.println(inner_list.get(j));
			}*/

			for(int j=row_start; j<=row_end; j++){
				inner_list = matrix.get(j);
				if(inner_list.get(col_end)==1) return false;
				System.out.println(inner_list.get(col_end));
			}

			inner_list = matrix.get(row_end);
			for(int j=col_end; j>=col_start; j--){
				if(inner_list.get(j)==1) return false;
				System.out.println(inner_list.get(j));
			}

			for(int j=row_end; j>=row_start; j--){
				inner_list = matrix.get(j);
				if(inner_list.get(row_start)==1) return false;
				System.out.println(inner_list.get(row_start));
			}

			row_start++;
			row_end--;
			col_start++;
			col_end--;
			k++;

			System.out.println("End of one Layer");
			//break;
		}
		return true;
  }

}
