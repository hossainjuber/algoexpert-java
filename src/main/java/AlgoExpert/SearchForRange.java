package AlgoExpert;

public class SearchForRange {

    public static void main(String[] args){
        //int[] array = {3,4,2,1,2,3,7,1,1,1,3};
        int[] array = {0,1,21,33,45,45,45,45,45,45,61,71,73};
        int target = 45;
        int[] result =searchForRange(array, target);
        System.out.println("The End");
   }


   public static int[] searchForRange(int[] array, int target) {
    return getRange(array, target, 0, array.length);
  }

	public static int[] getRange(int[] array, int target, int head, int tail){

		int middle = (head+tail)/2;
		//case#1: target may be got chopped, lets check
		if(target==array[middle]){
			int i=0;
			for(i=middle; i>=0; i--){
				if(array[i]!=target) break;
			}
			int j=0;
			for(j=middle; j<array.length; j++){
				if(array[j]!=target) break;
			}
			int[] result = new int[] {i+1, j-1};
			return result;
		}
		if(target<array[middle]){
			return getRange(array, target, head, middle-1);
		}else{
			return getRange(array, target, middle+1, tail);
		}

	}
}
