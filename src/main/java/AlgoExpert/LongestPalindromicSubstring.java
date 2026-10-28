package AlgoExpert;

public class LongestPalindromicSubstring {

    public static void main(String[] str){
        //String string = "z234a5abbba54a32z";
		String string = "abcdefgfedcbazzzzzzzzzzzzzzzzzzzz";
        longestPalindromicSubstring(string);
    }

      public static String longestPalindromicSubstring(String str) {
    // Write your code here.
		if(str==null || str.length()<=1){
			return str;
		}
		String pd1="";
		String pd2="";
		String result = "";
		for(int i=1;i<str.length(); i++){
			//locating the center
      if(i+1<str.length() && str.charAt(i-1)==str.charAt(i+1)) {
				pd1 = getPalindrome(str, i, -1);
			}else if( (str.charAt(i-1)==str.charAt(i)) ){
				pd1 = getPalindrome(str, i-1, i);
			}else{
				pd1 = String.valueOf(str.charAt(i-1));
			}

			if(pd1.length()>pd2.length()) {
                pd2 = pd1;
            }
			pd1 = "";

		}
    return pd1.length()>pd2.length()? pd1:pd2;
  }

	public static String getPalindrome(String str, int left, int right){
		int l = left;
		int r = right;
		StringBuffer sb = new StringBuffer();
		if(r==-1){
		// has a center with one letter
			l = left-1;
			r = left+1;
			sb.append(String.valueOf(str.charAt(l)));
			sb.append(String.valueOf(str.charAt(left)));
			sb.append(String.valueOf(str.charAt(r)));
		}else{
			sb.append(String.valueOf(str.charAt(l)));
			sb.append(String.valueOf(str.charAt(r)));
		}

		l--;
		r++;
		if(l<0 || r>=str.length()){
			return sb.toString();
		}

		while((l>=0 && r<str.length()) && str.charAt(l)==str.charAt(r)){
			sb.insert(0, String.valueOf(str.charAt(l)));
			sb.append(String.valueOf(str.charAt(r)));
			l--;
			r++;
		}

		return sb.toString();
	}
}

