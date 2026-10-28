package AlgoExpert;

public class SubArraySort {
    public static void main(String[] args){
        //int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        //int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};
        //int[] array = {4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7};
        //int[] array = {1,2};
        //int[] array = {2,1};
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};
        subarraySort(array);

    }

    public static int[] subarraySort(int[] array) {
        // Write your code here.
        /*
		1. Iterate over the array and mark all numbers that are not sorted
		2. within that range find the smallest and the largest numbers
		3. Find the index where the smallest number belongs
		4. FInd the index of the largest number where it belongs in the array
		*/
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0; i<array.length; i++){
            if(( i<array.length-1 && array[i] > array[i+1]) || (i>0 && array[i] < array[i-1]) ){
                startIndex = i;
                //startIndex++;
                break;
            }
        }

        for(int j=array.length-1; j>0; j--){
            if(( j>0 && array[j] < array[j-1]) || (j < array.length-1 && array[j] > array[j+1])){
                endIndex = j;
                //endIndex--;
                break;
            }
        }
        if(startIndex==0 && endIndex==0){
            return new int[]{-1, -1};
        }

        int s1 = startIndex;
        int s2 = startIndex;
        int l1 = startIndex;
        int l2 = endIndex;
        startIndex++;
        while(startIndex<=endIndex){
            s1 = Math.min(array[startIndex-1], s1);
            l1 = Math.max(array[startIndex-1], l1);
            startIndex++;
        }

        for(int k=0; k<array.length; k++){
            if(s1<array[k]){
                s2=k;
                break;
            }
        }
        for(int m=array.length-1; m>=0; m--){
            if(l1 > array[m]){
                l2=m;
                break;
            }
        }
        int[] result = new int[]{s2, l2};
        return result;
    }
}
