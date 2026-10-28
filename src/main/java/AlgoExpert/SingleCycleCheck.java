package AlgoExpert;

public class SingleCycleCheck {

    public static void main(String[] str){
        int[] array = {2, 3, 1, -4, -4, 2};
        hasSingleCycle(array);
    }

    public static boolean hasSingleCycle(int[] array) {
        int[] frequency_counter = new int[array.length];
		int next_index = 0;
		int length = array.length;
		int counter = 0;
		//if(array.length>1) frequency_counter[0] = -1;
		while(counter < length){
			next_index = (next_index + array[next_index]) % length;
            next_index = next_index >=0 ? next_index : next_index + length;

			if(frequency_counter[next_index]+1 > 1) {
				return false;
			}
			frequency_counter[next_index] = frequency_counter[next_index] +1;
			counter++;
		}
    return true;
  }
}
