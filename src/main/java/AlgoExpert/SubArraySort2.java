package AlgoExpert;

public class SubArraySort2 {
    public static void main(String[] args){
        //int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        //int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};
        //int[] array = {4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7};
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};
        //int[] array = {2,1};
        //int[] array = { 1, 2, 3, 4, 5, 6, 18, 21, 22, 7, 14, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 4,14, 11, 6, 33, 35, 41, 55};
        subarraySort(array);

    }

 public static int[] subarraySort(int[] array) {

		int start_index = 0;
        for(int i=0; i<array.length; i++){
            if(( i<array.length-1 && array[i] > array[i+1]) || (i>0 && array[i] < array[i-1]) ){
                start_index = i;
                //startIndex++;
                break;
            }
        }
        int end_index =0;
        for(int j=array.length-1; j>0; j--){
            if(( j>0 && array[j] < array[j-1]) || (j < array.length-1 && array[j] > array[j+1])){
                end_index = j;
                //endIndex--;
                break;
            }
        }

        if(start_index==0 && end_index==0){
            return new int[]{-1, -1};
        }

		int smallest = Integer.MAX_VALUE;
		int largest =Integer.MIN_VALUE;
		for(int k=start_index; k<=end_index; k++){
            smallest = Math.min(smallest, array[k]);
            largest = Math.max(largest, array[k]);
		}//for

		int startIndex = 0;
		for(int l=1; l<array.length; l++){
			if(l-1>=0 && smallest < array[l-1]){
				startIndex = l-1;
				break;
			}
		}//for

		int endIndex = 0;
		for(int m=array.length-1; m>=0; m--){
			if(m-1>=0 && largest >= array[m]){
				endIndex = m;
				break;
			}
		}

		int[] result = new int[]{startIndex, endIndex};
		return result;
  }
}
