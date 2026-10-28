package AlgoExpert;

public class interweavingStrings2 {

   public static void main(String[] args){

       /*String one = "algoexpert";
       String two = "your-dream-job";
       String three = "your-algodream-expertjob";*/

	   /*String one = "a";
       String two = "b";
       String three = "ab";*/

	   /*String one = "aaaaaaa";
       String two = "aaaaaaa";
       String three = "aaaaaaaaaaaaaa";*/

	   String one = "three";
       String two = "abcdef";
       String three = "def";

	   /*String one = "abc";
       String two = "adbecf";
       String three = "def";*/

	   /*String one = "abc";
       String two = "deabcf";
       String three = "def";*/

	   /*String one = "aabcc";
       String two = "aadbbcbcac";
       String three = "dbbca";*/

	   /*String one = "algoexpert";
       String two = "your-dream-job";
       String three = "ayloguore-xdpreeratm-job";*/

       interweavingStrings(one, two, three);
   }

  public static boolean interweavingStrings(String one, String two, String three) {
	int one_idx=0;
	int two_idx=0;
	int[] one_result = new int[2];
	int[] two_result = new int[2];
	int i;
	//if(one.length()+two.length()!=three.length()) return false;
   	for(i=0; i<three.length();){
		one_result = getMatchedEndIndex(one_idx, one, i, three);
		two_result = getMatchedEndIndex(two_idx, two, i, three);
		if(one_result[0]-one_idx > two_result[0]-two_idx){
			one_idx = one_result[0];
			i = one_result[1];
		}else if(one_result[0]-one_idx < two_result[0]-two_idx){
			two_idx = two_result[0];
			i = two_result[1];
		}else if(one_result[0]-one_idx == two_result[0]-two_idx && one_result[0]>0){
			two_idx = two_result[0];
			i = two_result[1];
		}else{
			one_result[0]++;
			two_result[0]++;
		}

	}//for
	  if(one_idx==one.length() && two_idx==two.length() && i==three.length()){
		return true;
	  }
	  return false;
  }

  /*   String one = "algoexpert";
       String two = "your-dream-job";
       String three = "your-algodream-expertjob";*/

	public static int[] getMatchedEndIndex(int small_idx, String small, int big_idx, String big){
		int[] result = new int[2];
		for(int i=small_idx; i<small.length(); i++){
			if(small.charAt(small_idx)!=big.charAt(big_idx)){
				continue;
			}else{
				small_idx++;
				big_idx++;
			}
		}//for
		//if(small_idx>=small.length()-1) small_idx = small.length()-1;
		//if(big_idx>=big.length()-1) big_idx = big.length()-1;
		result[0] = small_idx;
		result[1] = big_idx;
		return result;
	}

}
