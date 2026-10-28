package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaesarCypherEncryptor {

   public static void main(String[] args){
       caesarCypherEncryptor("xyz", 2);
   }

   public static String caesarCypherEncryptor(String str, int key) {
        str = str.toLowerCase();
		int ascii_value = 0;
		int nlc = 0;
		StringBuffer sb = new StringBuffer();
		char ch;
		key = key % 26;
		int j=0;
		for(int i=0; i<str.length(); i++){
			ascii_value = (int) str.charAt(i);
			nlc = ascii_value + key;
			ch = (char) nlc;
			if(nlc <= 122){
				sb.append(ch);
			}else{
				j = (96 + (nlc % 122));
				ch = (char) j;
				sb.append(ch);
			}
		}
    return sb.toString();
  }
}
