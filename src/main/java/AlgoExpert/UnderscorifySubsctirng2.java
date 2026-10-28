package AlgoExpert;

import java.util.ArrayList;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class UnderscorifySubsctirng2 {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        String s1 = "testestxyztest testtest is a testtest to see if testestest it works";
        String s2 = "test";
        //_test_this is a _testtest_ to see if _testestest_ it works_
        //underscorifySubstring(s1, s2);
        String result = underscorifySubstring(s1, s2);
    }

    public static String underscorifySubstring(String str, String substring) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        String temp = "";
        int index = 0;
        String occurrances = "";
        String occurrances_with_underscore = "";
        for(int i=0; i<str.length(); i++){
            temp = str.substring(i, i+substring.length());
            if(temp.equals(substring)){
                occurrances = findAllOccurrances(str, substring, i);
                occurrances_with_underscore = getOccurrancesWithUnderscore(occurrances);
                sb1.append(occurrances_with_underscore);
            }else{
                sb1.append(String.valueOf(str.charAt(i)));
            }
        }

        return null;
    }

    public static String findAllOccurrances(String str, String substring, int i){
        if(str==null || str.length()<=0){
            return str;
        }
        String word = str.substring(i, str.indexOf(" ", i));
        String temp1 = "";
        String temp2 = "";
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        //boolean keep_going = true;
        //testtestxyz
        //testestestxyz
        int length = substring.length();
        int[] tracker = new int[str.length()];
        for(int j=0; j<str.length(); j++){
            if(j+length >= str.length()){
                temp1 = str.substring(j);
            }else{
                temp1 = str.substring(j, j+length);
            }

            if(temp1.equals(substring)){
                tracker[j] = 1;
                tracker[j+length-1] = 1;
                if((j>0 && tracker[j-1]!='_') || j==0) sb1.append("_");
                //sb1.append("_");
                sb1.append(str.substring(j, j+length));
                if((j>0 && tracker[j-1]!='_') || j==0) sb1.append("_");
            }else{
                if(sb1.length()>0){
                    sb2.append(sb1.toString());
                    sb1 = new StringBuffer();
                }
                sb2.append(String.valueOf(str.charAt(j)));
            }
        }//for



        return sb1.toString();
    }

    public static String getOccurrancesWithUnderscore(String str){
        if(str==null || str.length()<=0){
            return str;
        }
        return "_"+str+"_";
    }

}
