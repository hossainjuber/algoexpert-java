package AlgoExpert;

import java.util.PriorityQueue;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class KSortedArray2 {

    public static void main(String[] str){
    	/*int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
    	int k = 3;*/
		/*int[] array = {4, 3, 2, 1, 2, 5, 6};
    	int k = 4;*/
		/*int[] array = {-1, -3, -4, 2, 1, 3};
    	int k = 2;*/
		int[] array = {3, 2, 1, 5, 4, 7, 6, 5};
    	int k = 3;

    	sortKSortedArray(array, k);
    }

	public static int[] sortKSortedArray(int[] array, int k) {
    /*
    1. create a heap and add elements from the array up to k position
    2. create two points, one keeps track of arrays sorted portion
    3. the other points to k+1 index
    */
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int j = 0;
		while(j<Math.min(k+1, array.length)){
			heap.add(array[j]);
			j++;
		}
		int idx = 0;
		for(int i=k+1; i<array.length; i++){
			int minElement = heap.remove();
			array[idx] = minElement;
			idx = idx+1;

			int currentElement = array[i];
			heap.add(currentElement);
		}
		while(!heap.isEmpty()){
			int minElement = heap.remove();
			array[idx] = minElement;
			idx = idx+1;
		}
		return array;
	}


}
