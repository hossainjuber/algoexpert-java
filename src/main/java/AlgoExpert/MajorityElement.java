package AlgoExpert;

public class MajorityElement {

    public static void main(String[] str){
        int[] array = {1, 2, 1};
		int result = majorityElement(array);
    }

	public static int majorityElement(int[] array) {
		int prevNum = array[0];
		int currFreq = 0;
		for(int i=1; i<array.length; i++){
			if(array[i]==prevNum){
				currFreq++;
			}else{
				currFreq--;
			}
			if(currFreq<0){
				prevNum = array[i];
				currFreq =1;
			}
		}//for
		return prevNum;
	}
}
