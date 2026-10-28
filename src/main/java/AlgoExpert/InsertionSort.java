package AlgoExpert;

//https://www.algoexpert.io/questions/Branch%20Sums
//Time complexity: O(n*n)
//Space complexity: O(1)
public class InsertionSort {

   public static void main(String[] args) {
       int[] array = {8, 5, 2, 9, 5, 6, 3};
       insertionSort(array);
   }

    public static int[] insertionSort(int[] array) {
        // Write your code here.
        int temp1 =0;
        int temp2 =0;
        int t = 0;
        for(int i=1; i<array.length; i++){
            t = i;
            while(t>0){
                if(array[t-1] > array[t]){
                    temp1 = array[t-1];
                    array[t-1] = array[t];
                    array[t] = temp1;
                }
                t--;
            }//while
        }//for
        return array;
    }

}
