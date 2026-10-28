package AlgoExpert;

import java.util.ArrayList;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class UnderscorifySubsctirng4 {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        String s1 = "testtest is a testtest to see if testestest it works";
        String s2 = "test";
        //_test_this is a _testtest_ to see if _testestest_ it works_
        String result = underscorifySubstring(s1, s2);
        System.out.println(result);
        System.out.println("The End");

    }

    public static String underscorifySubstring(String str, String substring) {
        StringBuffer sb = new StringBuffer();
        String[] array = str.split(" ");
        for(int i=0; i<array.length; i++){
            sb.append(updateString(array[i], substring));
            sb.append(" ");
        }
        sb.append(updateString(str, substring));
        return sb.toString().trim();
    }

    public static String updateString(String token, String pattern){
        int index = 0;
        int[] tracker = new int[token.length()];
        int tracker_index = 0;
        for(int i=0; i<token.length(); i++){
            index = token.indexOf(pattern, i);
            if(index>=0){
                tracker = updateTracker(tracker, index, index+pattern.length()-1);
                i=i+pattern.length()-2;
            }//if
        }//for

        StringBuffer sb = new StringBuffer();
        boolean startFound=false;
        boolean endFound=false;
        for(int j=0; j<tracker.length; j++){
            if(tracker[j]==1){
                startFound=true;
                j=j+pattern.length()-2;
            }else if(tracker[j]==0 && startFound){
                endFound=true;
                startFound=false;
                sb.append(getPrePostUnderscores(token.substring(j-pattern.length(), j-1)));
            }else if(tracker[j]==0 && !startFound){
                sb.append(String.valueOf(token.charAt(j)));
            }
        }//for
        if(startFound && sb.toString().length()==0){
            sb.append(getPrePostUnderscores(token));
        }
        return sb.toString();

    }

    public static int[] updateTracker(int[] array, int start, int end){
        for(int i=start; i<=end; i++){
            array[i] = 1;
        }
        return array;
    }

    public static String getPrePostUnderscores(String str){
        return "_" + str + "_";
    }

}
