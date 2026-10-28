package AlgoExpert;

import java.util.ArrayList;

public class LongestPeak4 {

   public static void main(String[] args){
       //int[] array = new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
	   int[] array = new int[] {1,3,2};
	   //int[] array = new int[] {5,4,3,2,1,2,1};
	   //int[] array = new int[] {5,4,3,2,1,2,10,12};
       int result = longestPeak(array);
   }

	  public static int longestPeak(int[] array) {
    /*
		 * 1. Identify the center of the peaks
		 * 2. From each center span out left and right and make that current max
		 * 3. contineu the process til you find the peak
		 */
		if(array==null || array.length<3) return 0;
		ArrayList<Integer> list = getPeaks(array);
		if(list.size()==0) return 0;
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for(Integer i : list){
			max1 = spanOutFromThePeak(array, i);

			max2 = Math.max(max1, max2);
		}
		int max =  max1>max2 ? max1 :max2;
		return max+1;
  }

	public static int spanOutFromThePeak(int[] array, int center){
		int peak_length = 0;
		//expand left:
		int i = center;
		while(i>0 && array[i-1]<array[i]){
			peak_length++;
			i--;
		}
		i = center;
		while(i<array.length-1 && array[i+1]<array[i]){
			peak_length++;
			i++;
		}
		return peak_length;
	}

	public static ArrayList<Integer> getPeaks(int[] array){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=array.length-2; i++){
			if(array[i-1] < array[i] && array[i]> array[i+1]){
				list.add(i);
			}
		}
		return list;
	}




}
