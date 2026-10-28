package AlgoExpert;

import java.util.ArrayList;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class UnderscorifySubstring {

    public static void main(String[] str){
        //String s1 = "testbesttest testthis is a testtest to see if testestest it works";
        String s1 = "testthis is a testtest to see if testestest it works";

        //String s1 = "testestest testtest is a testtest to see if testestest it works";
        String s2 = "test";
        //_test_this is a _testtest_ to see if _testestest_ it works_
        underscorifySubstring(s1, s2);
    }

    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        StringBuffer sb = new StringBuffer();
        String[] array = str.split(" ");
        for(int i=0; i<array.length; i++){
            if(array[i].indexOf(substring)>-1){
                String updatedString = addUnderscore(array[i], substring);
                sb.append(updatedString);
            }else{
                sb.append(array[i]);
            }
            sb.append(" ");
        }//for
        return String.join(" ", sb.toString());
    }
    public static String addUnderscore(String str, String substring){
        int idx = 0;
        int idxOfSubStr = str.indexOf(substring);
        int start = 0;
        int end = 0;
        if(idxOfSubStr>-1) {
            start = idxOfSubStr;
        }else {
            return str;
        }

        while(idx<str.length() && idxOfSubStr>0){
            if(idxOfSubStr>-1){
                idxOfSubStr = str.indexOf(substring, idx+substring.length()-1);
                idx = idxOfSubStr;
            }
        }//while

        end = idx+substring.length()-1;
        int j = 0;
        StringBuffer sb = new StringBuffer();
        while(j<str.length()){
            if(j==start) {
                sb.append("_");
                sb.append(str.charAt(j));
            }else if(j==end){
                sb.append(str.charAt(j));
                sb.append("_");
            }else {
                sb.append(str.charAt(j));
            }
            j++;
        }
        return sb.toString();
    }

}
