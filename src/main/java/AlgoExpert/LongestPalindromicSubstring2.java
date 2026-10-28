package AlgoExpert;

public class LongestPalindromicSubstring2 {

    public static void main(String[] str){
        //String string = "z234a5abbba54a32z";
		String string = "zzzzzzz2345abbbba5432zzbbababa";
        String result = longestPalindromicSubstring(string);
        System.out.println("The End");
    }

	public static String longestPalindromicSubstring(String str) {
		if(str==null || str.length()<1){
			return "";
		}else if(str.length()==1){
			return str;
		}else if(str.length()==2 && str.charAt(0)==str.charAt(1)){
			return str;
		}
		String p1 = "";
		String p2 ="";
		String p3 ="";
		String largest ="";
		for(int i=1; i<str.length(); i++){
			//odd length Palindrome
			if(i+1<str.length() && str.charAt(i-1)==str.charAt(i+1)){
				p1 = expandPalindrome(str, i, -1);
			}
			if(str.charAt(i-1)==str.charAt(i)){
				p2 = expandPalindrome(str, i-1, i);
			}
			if(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
				p3 = expandPalindrome(str, i, i+1);
			}

			if(p1.length()>=p2.length()){
				if(largest.length()<p1.length()){
					largest = p1;
				}
			}else{
				if(largest.length()<p2.length()){
					largest = p2;
				}
			}
			if(largest.length()<=p3.length()){
				if(largest.length()<p3.length()){
					largest = p3;
				}
			}
		}//for
		return largest;
	}//longestPalindromicSubstring

	public static String expandPalindrome(String str, int idx1, int idx2){
		int head=0;
		int tail=0;
		if(idx2==-1){
			//odd length Palindrome
			head = idx1;
			tail = idx1;
		}else{
			//even length Palindrome
			head = idx1;
			tail = idx2;
		}

		while(head-1>=0 && (tail+1 <str.length()) && (str.charAt(head-1)==str.charAt(tail+1))){
			head--;
			tail++;
		}//while

		if(tail==str.length()-1){
			return str.substring(head);
		}
		return str.substring(head, tail+1);

	}//expandPalindrome

}

