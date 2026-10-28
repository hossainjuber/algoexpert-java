package AlgoExpert;
//AlgoExpert/MedianOfTwoSortedArrays.java
public class MedianOfTwoSortedArrays {

    public static void main(String[] str){
        /*int[] arrayOne = {1,3,4,5, 7, 9};
        int[] arrayTwo = {0,1,2,2,4};
        int[] arrayOne = {6,7,8,9};
        int[] arrayTwo = {1,3,4,5};

        int[] arrayOne = {1};
        int[] arrayTwo = {2,3};

        int[] arrayOne = {1,3,4};
        int[] arrayTwo = {2,3,6};*/

        int[] arrayOne = {1,3,4,5};
        int[] arrayTwo = {2,3,6,7};

        float result = medianOfTwoSortedArrays(arrayOne, arrayTwo);
            System.out.println("Result: " + result);
    }

    public static float medianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
        int a=0;
        int b=0;
        //even length
        int mid = (((arrayOne.length) + (arrayTwo.length))-1) / 2;
        /*if((arrayOne.length+arrayTwo.length)%2==0) {
            mid = ((arrayOne.length) + (arrayTwo.length)) / 2;
        }else{
            mid = (((arrayOne.length) + (arrayTwo.length))-1) / 2;
        }*/
        while(a+b<mid && a+1<arrayOne.length && b+1<arrayTwo.length){
            if(arrayOne[a]>arrayTwo[b]){
                b++;
            }else if(arrayOne[a]<arrayTwo[b]){
                a++;
            }else{
                a++;
                b++;
            }
        }//
        //Even case
        if((arrayOne.length+arrayTwo.length)%2==0){
            if(a+1<= arrayOne.length-1 && arrayOne[a]==arrayOne[a+1]) {
                return arrayOne[a];
            }else{
                return ((float)arrayOne[a]+arrayTwo[b])/2;
            }
        }else{
            if(b+1<= arrayTwo.length-1 && arrayTwo[b]==arrayTwo[b+1]) {
                return arrayTwo[b];
            }else{
                return Math.max(arrayOne[a], arrayTwo[b]);
            }
        }
    }
}
