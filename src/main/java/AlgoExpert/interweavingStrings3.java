package AlgoExpert;

public class interweavingStrings3 {

   public static void main(String[] args){

       String one = "algoexpert";
       String two = "your-dream-job";
       String three = "your-algodream-expertjob";

	   /*String one = "a";
       String two = "b";
       String three = "ab";*/

	   /*String one = "aaaaaaa";
       String two = "aaaaaaa";
       String three = "aaaaaaaaaaaaaa";*/

	   /*String one = "three";
       String two = "abcdef";
       String three = "def";*/

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
	  boolean itMatched_j = true;
	  boolean itMatched_k = true;
	  if(one.length()+two.length()!=three.length()) return false;
	  int k=-1;
	  int j=-1;
	  int i=0;
	  //for(int i=0; i<three.length(); i++){
	  while(i<three.length()){
	  					  j++;
		  while(j<one.length()){
			  if(one.charAt(j)!=three.charAt(i)){
				  if(k>=two.length()-1) return false;
				  itMatched_j = false;
				  j--;
				  break;
			  }else{
				  itMatched_j = true;
				  i++;
				  j++;
			  }

		  }//while
				  k++;
		  while(k<two.length()){
			  if(two.charAt(k)!=three.charAt(i)){
				  if(j>=one.length()-1) return false;
				  itMatched_k = false;
				  k--;
				  break;
			  }else{
				  itMatched_k = true;
				  i++;
				  k++;
			  }

		  }//while
	  }//for
	  return true;
  }


}
