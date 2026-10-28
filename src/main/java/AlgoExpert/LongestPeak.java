package AlgoExpert;

public class LongestPeak {

   public static void main(String[] args){
       int[] array = new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
       int result = longestPeak(array);
   }

   public static int longestPeak(int[] array) {
    // Write your code here.
		if(array.length<3){
			return 0;
		}
		int p1 = 0;
		int p2 = 0;
		boolean peakStarted = false;
		for(int i=1; i<array.length; i++){
			if(array[i-1] < array[i]){
				peakStarted = true;
				p1++;
			}else if(peakStarted && array[i-1] == array[i]){
				p1++;
			}else if(peakStarted && array[i-1] > array[i]){
				peakStarted = false;
				if(p1>p2){
					p2 = p1;
				}
				p1 = 0;

			}else{
				continue;
			}

		}
    return p1>p2? p1:p2;
  }
}
