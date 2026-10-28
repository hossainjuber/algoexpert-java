package AlgoExpert;

//https://www.algoexpert.io/questions/Selection%20Sort
//Time complexity: O(n*n)
//Space complexity: O(1)
public class SelectionSort {

   public static void main(String[] args) {
       int[] array = {1, 3, 2};
       String s;

       selectionSort(array);
   }

    public static int[] selectionSort(int[] array) {
        // Write your code here.
        int temp = 0;
        int p1 =1;
        int p2 =1;
        int sub = 1;
        int current_smallest = 0;
        for(int i=0; i< array.length; i++){
            current_smallest = i;
            for(int j=i; j< array.length; j++){
                if(array[current_smallest] > array[j] && current_smallest!=j){
                    current_smallest = j;
                }
            }//for
            temp = array[i];
            array[i] = array[current_smallest];
            array[current_smallest] = temp;


        }//for
        return array;
    }

}
