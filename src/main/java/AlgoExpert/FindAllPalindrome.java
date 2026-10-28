package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

/*Find the largest palindrome in a given string,
* What is a Palindrome?
* i.e.: xyzaxyz, xyzaaxyz
*
* Please note the center of the palindrome may/may not repeat.
*
*
*
* */
public class FindAllPalindrome {

    public static void main(String[] str){
        //String string = "z234a5abbba54a32z";
		//tring string = "abcdefgfedcbazzzzzzzzzzzzzzzzzzzz";
		String string = "abaxyzzyxf";
        longestPalindromicSubstring(string);
    }

    /*
    * 1. Iterate over the given string and try to find the center of this palindrome
    * 2. Easy case: the center does not repeat
    * 3. Tricky case: the center repeats and may be even or odd
    * 	i. find the index to the left where center ends
    * 	ii. find the index to the right where the center ends
    * 4. Start comparing the index values after the center on the left and right and check to see if they are equal.
    *
    */
    public static List<String> findAllPalindromes(String str){
    	List<String> result = new ArrayList<>();
    	for(int i=1; i<str.length(); i++){
    		
		}


    	return result;

	}

      public static List<String> longestPalindromicSubstring(String str) {
			String p1 = "";
			String p2 = "";
			List<String> list = new ArrayList<>();
    		for(int i=1; i<str.length(); i++){
    			if(str.charAt(i-1)==str.charAt(i)){
					p1 = isPalendrome(str, i,false);
				}else{
    				p1 = isPalendrome(str, i,true);
				}
    			list.add(p1);

			}

    		return list;
	  }

	  public static String isPalendrome(String pal, int index, boolean singleCenter){
			int max_right = pal.length();
			int right = index+1;
			int left = index-1;
    		if(!singleCenter){
				left = left-1;
			}

    		if(left<0 || right>pal.length()-1) return String.valueOf(pal.indexOf(index));

			while(left>=1 && right<=max_right){
				if(pal.charAt(left)!=pal.charAt(right)){
					break;
				}
				left--;
				right++;
			}
			//left++;
			//right--;
			if(right==pal.length()-1) return String.valueOf(pal.substring(left));
			return String.valueOf(pal.substring(left, right+1));
	  }//isPalendrome



}

