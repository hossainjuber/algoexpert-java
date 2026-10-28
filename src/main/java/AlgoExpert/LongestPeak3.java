package AlgoExpert;

public class LongestPeak3 {

   public static void main(String[] args){
       int[] array = new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
	   //int[] array = new int[] {1,3,2};
	   //int[] array = new int[] {5,4,3,2,1,2,1};
	   //int[] array = new int[] {5,4,3,2,1,2,10,12};
       int result = longestPeak(array);
   }

	public static int longestPeak(int[] array) {
		int peak1 = 0;
		int peak2 = Integer.MIN_VALUE;
		for(int i=1; i<array.length-1; i++){

			if(array[i-1]<array[i] && array[i]>array[i+1]){
				//found the peak
				peak1++;
				int left_idx = i;
				//find length of the left side
				while(left_idx-1 > -1){
					if(array[left_idx-1]<array[left_idx]){
						peak1++;
						left_idx--;
					}else{
						break;
					}
				}//while

				int right_idx = i;
				//find length of the left side
				while(right_idx+1 < array.length){
					if(array[right_idx] > array[right_idx+1]){
						peak1++;
						right_idx++;
					}else{
						break;
					}
				}//while
				if(peak1>peak2){
					peak2 = peak1;
				}
				peak1 = 0;
			}//if

		}//for
		return peak1>peak2 ? peak1:peak2;
	}




}
