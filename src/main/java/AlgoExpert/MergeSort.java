package AlgoExpert;

import java.util.Arrays;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class MergeSort {

    public static void main(String[] str){
		//int[] unsorted_array = {2,5,6,9,8,7,3,8};
		int[] unsorted_array = {8, 5, 2, 9, 5, 6, 3};
        unsorted_array = mergeSort(unsorted_array);
        System.out.println("The End");
    }

  public static int[] mergeSort(int[] array) {
    	/*
    	* 1. divide up the array until each array contains single elements
    	* 2. compare the single element arrays and merge them
    	* */
	    if(array.length<=1){
	    	return array;
		}
	  	int middle = array.length/2;
	  	int[] left_half = Arrays.copyOfRange(array, 0, middle);
	  	int[] right_half = Arrays.copyOfRange(array, middle, array.length);
	  	return merge(mergeSort(left_half), mergeSort(right_half));
  }

  public static int[] merge(int[] leftHalf, int[] rightHalf){
    	int[] merged = new int[leftHalf.length + rightHalf.length];
    	int a=0;
    	int b=0;
    	int c=0;
    	while(a<leftHalf.length && b<rightHalf.length){
    		if(leftHalf[a]<=rightHalf[b]){
    			merged[c++] = leftHalf[a++];
			}else{
    			merged[c++] = rightHalf[b++];
			}
		}
    	while(a<leftHalf.length){
    		merged[c++] = leftHalf[a++];
		}
    	while(b<rightHalf.length){
    		merged[c++] = rightHalf[b++];
		}
    	return merged;
  }

}
