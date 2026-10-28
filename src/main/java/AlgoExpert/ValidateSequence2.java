package AlgoExpert;

import java.util.Arrays;
import java.util.List;

//https://www.algoexpert.io/questions/Validate%20Subsequence
public class ValidateSequence2 {

    public static void main(String[] str){
        List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = Arrays.asList(100);
        boolean result = isValidSubsequence(array, sequence);
        System.out.println("The End");
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int array_tracker =0;
		int sequence_tracker= 0;
		while(sequence_tracker<sequence.size()){
			while(array_tracker<array.size()){
				if(sequence.get(sequence_tracker) == array.get(array_tracker)){
					sequence_tracker++;
					array_tracker++;

				}else{
					array_tracker++;
				}
			}//while
            //if(array_tracker==array.size()-1 && sequence_tracker){

            //}
  	    }//while

		if(sequence_tracker==sequence.size()) {
			return true;
		}
		return false;
    }

}


