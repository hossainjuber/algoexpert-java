package AlgoExpert;

public class LongestPalindromicSubstring3 {

    public static void main(String[] str){
        //String string = "z234a5abbba54a32z";
		//tring string = "abcdefgfedcbazzzzzzzzzzzzzzzzzzzz";
		String string = "abaxyzzyxf";
        longestPalindromicSubstring(string);
    }

      public static String longestPalindromicSubstring(String str) {
			String p1 = "";
			String p2 = "";
    		for(int i=1; i<str.length(); i++){
    			if(str.charAt(i-1)==str.charAt(i)){
					p1 = isPalendrome(str, i,false);
				}else{
    				p1 = isPalendrome(str, i,true);
				}
    			if(p1.length()>p2.length()){
    				p2 = p1;
				}

			}

    		return p1.length()>p2.length() ? p1 : p2;
	  }

	  public static String isPalendrome(String pal, int index, boolean singleCenter){
			int max_right = pal.length();
			int right = index+1;
			int left = index-1;
    		if(!singleCenter){
				left = left-1;
			}

    		if(left<0 || right>pal.length()-1) return String.valueOf(pal.indexOf(index));

			while(left>=1 && right<=max_right && pal.charAt(left)==pal.charAt(right)){
				left--;
				right++;
			}
			left++;
			right--;
			if(right==pal.length()-1) return String.valueOf(pal.substring(left));
			return String.valueOf(pal.substring(left, right+1));
	  }//isPalendrome



}

