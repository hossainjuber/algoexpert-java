package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class KSortedArray {

    public static void main(String[] str){
    	/*int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
    	int k = 3;*/
		/*int[] array = {4, 3, 2, 1, 2, 5, 6};
    	int k = 4;*/
		/*int[] array = {-1, -3, -4, 2, 1, 3};
    	int k = 2;*/
		int[] array = {1, 2, 3, 4, 5};
    	int k = 0;

    	sortKSortedArray(array, k);
    }

   public static int[] sortKSortedArray(int[] array, int k) {
    /*
		1. for each iteration i, determine the left and right bounds
		2. get the min within that bound
		3. insert the min in position i
		*/
		int[] result = new int[array.length];
		for(int i=0; i<array.length; i++){
			int[] bounds = getBounds(i, array.length, k);
			int smallest_idx = findSmallest(array, bounds[0], bounds[1]);
			result[i] = array[smallest_idx];
			array[smallest_idx] = Integer.MAX_VALUE;
		}
		return result;
  }

	public static int findSmallest(int[] array, int i, int j){
		int m2 = Integer.MAX_VALUE;
		int si = 0;
		for(int k=i; k<=j; k++){

			if(array[k] < m2){
				m2 = array[k];
				si=k;
			}
		}//for
		return si;
	}
	public static int[] getBounds(int current_position, int size, int k){
		//get left bound
		int i=current_position;
		int i_counter=0;
		while(i>0){
			i--;
			i_counter++;
			if(i_counter==k) break;
		}
		//get right bound
		int j=current_position;
		int j_counter = 0;
		if(current_position+k>=size-1){
			int[] range = {i, size-1};
			return range;
		}
		while(j<=size-1){
			if(j_counter==k) break;
			j++;
			j_counter++;

		}
		int[] range = {i, j};
		return range;
	}

}
