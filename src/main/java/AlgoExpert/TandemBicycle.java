package AlgoExpert;

import java.util.*;

public class TandemBicycle {

   public static void main(String[] args){
        int[] blue_shirt = {3, 3, 4, 6, 1, 2, 5, 6, 34, 256, 123, 32};
        int[] red_shirt = {1, 2, 1, 9, 12, 3, 1, 54, 21, 231, 32, 1};
        tandemBicycle(red_shirt, blue_shirt, true);
   }

     public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);

		if(fastest){
			blueShirtSpeeds = getSortedArrayReversed(blueShirtSpeeds);
		}

		int[] result = new int[redShirtSpeeds.length];
		int sum =0;
		for(int i=0; i<redShirtSpeeds.length; i++){
			result[i] = Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
			sum = sum+ result[i];
		}
		return sum;
  }

	public static int[] getSortedArrayReversed(int[] array){
		int[] result = new int[array.length];
		for(int i=0; i<(array.length-1)/2; i++){
			result[i] = array[array.length-1-i];
			result[array.length-1-i] = array[i];
		}//for
        if(array.length%2>0){
            result[((array.length-1)/2)] = array[((array.length-1)/2)];
        }
		return result;
	}//getSortedArrayReversed


}
