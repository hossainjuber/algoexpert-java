package AlgoExpert;

public class NextGreatElement {

    public static void main(String[] args){
        int[] array = {2,5,-3,-4,6,7,2};
        nextGreaterElement(array);

    }

    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        int circular_index = 1;

        for(int i=0; i<array.length; i++) {
            for (int idx = i+1; idx < 2 * array.length; idx++) {
                circular_index = idx % array.length;
                if(array[i]<array[circular_index]){
                    result[i] = array[circular_index];
                    break;
                }
                if(i==circular_index){
                    result[i] = -1;
                    break;
                }

            }
        }
        return result;
    }
}
