package AlgoExpert;

public class LongestPeak2 {

   public static void main(String[] args){
       //int[] array = new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
	   //int[] array = new int[] {1,3,2};
	   //int[] array = new int[] {5,4,3,2,1,2,1};
	   int[] array = new int[] {5,4,3,2,1,2,10,12};
       int result = longestPeak(array);
   }

	public static int longestPeak(int[] array) {
		if(array.length <3) return 0;
		int center = 0;
		int left = 0;
		int right = 0;
		int total1 = 0;
		int total2 = 0;
		for(int i=1; i<array.length; i++){
			left = calcLeftLength(array, i);
			right = calcRightLength(array, i);
			if(left>0 && right>0)total1 = 1 + left + right;
			else if(left==0 || right==0) continue;
			else total1 = left+right;
			if(total1 > total2){
				total2 = total1;
			}
		}//for
		return total1 > total2 ? total1 : total2;
	}

	public static int calcLeftLength(int[] array, int center){
		//direction==true => left
		int length = 0;
		for(int i=center; i>=0; i--){
			if(i-1>=0 && array[i-1]<array[i]){
				length++;
			}else{
				break;
			}
		}
		return length;
	}

	public static int calcRightLength(int[] array, int center){
		//direction==true => left
		int length = 0;
		for(int i=center; i<array.length; i++){
			if(i+1<array.length && array[i+1]<array[i]){
				length++;
			}else{
				break;
			}
		}
		return length;
	}
}
