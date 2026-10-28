package AlgoExpert;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatternMatcher2 {

    public static void main(String[] str){
        //String[] result = patternMatcher("yxx", "yomama");
        //String[] result = patternMatcher("xxyxxy", "gogopowerrangergogopowerranger");
        //String[] result = patternMatcher("yxyx", "abab");
        //String[] result = patternMatcher("xyx", "thisshouldobviouslybewrong");
        //String[] result = patternMatcher("xxxx", "testtesttesttest");
        String[] result = patternMatcher("xxyxyy", "baddaddoombaddadoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom");
        //String[] result = patternMatcher("xyxxxyyx", "baddaddoombaddadoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom");
    }

    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        int str_length = str.length();
        System.out.println("str.length(): "+ str_length);
        int x_count=0;
        int y_count=0;
        pattern = pattern.toLowerCase();
        boolean flipped = false;
        if(pattern.charAt(0)=='y'){
            flipped = true;
            pattern = flipIt(pattern);
        }

        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i)=='x'){
                x_count++;
            }else if(pattern.charAt(i)=='y'){
                y_count++;
            }
        }

        int x_length=1;
        int total_y_length = str.length() - (x_count * x_length);
        //calculating length of y:

        int y_length = 0;
        if(y_count>0) {
            y_length = total_y_length / y_count;
        }
        String x_sub=null;
        String y_sub=null;
        String pattern_created = "";

        while(x_length<str.length()/2){
            total_y_length=str.length() - (x_count * x_length);
            if(y_count>0 && total_y_length > 0 && total_y_length % y_count >0) {
                x_length++;
                continue;
            }

            if(total_y_length<0){break;}

            if(y_count>0) {
                y_length = total_y_length / y_count;
            }
            x_sub = str.substring(0,x_length);
            y_sub = create_y(pattern, str, x_sub, y_length);
            pattern_created =  createFinalString(pattern, x_sub, y_sub);
            if(pattern_created.equals(str)){
                if(flipped){
                    return new String[]{y_sub, x_sub};
                }else{
                    return new String[]{x_sub, y_sub};
                }

            }
            x_length++;
        }//while
        return new String[]{};
    }

        public static String createFinalString(String pattern, String x, String y){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                sb.append(x);
            }else if (pattern.charAt(i) == 'y') {
                sb.append(y);
            }
        }
        return sb.toString();
    }


    public static String create_y(String pattern, String str, String x, int y_length){
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i)=='x'){
                sb.append(x);
            }else{
                break;
            }
        }
        String y = str.substring(sb.toString().length(), (sb.toString().length()) + y_length);
        return y;
    }

    public static String flipIt(String str){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='y'){
                sb.append(String.valueOf('x'));
            }else if(str.charAt(i)=='x'){
                sb.append(String.valueOf('y'));
            }
        }
        return sb.toString();
    }

    /*public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        str = str.toLowerCase();
        boolean flipped = false;
        if(pattern.charAt(0)=='y'){
            flipped = true;
            pattern = flipIt(str);
        }
        int len = str.length();
        int x_count = countTargetLetter('x', pattern);
        int y_count = countTargetLetter('y', pattern);
        int x_length = 1;
        int calc_length =0;
        int y_length = 0;
        int y_start_position_in_pattern = 0;
        int y_start_position_in_str = 0;
        if(y_count>0){
            y_length = (len - (x_count*x_length))/y_count;
            y_start_position_in_pattern = findYPosition(pattern, 'y');
            y_start_position_in_str = 0;
        }

        String potential_x = "";
        String potential_y = "";
        String actual_x_y = "";
        String[] result = null;
        while(x_length<len){
            if(y_count>0) {
                y_length = (len - (x_count*x_length))/y_count;
                calc_length = (x_length * x_count) + (y_length * y_count);
                if (calc_length != len) {
                    continue;
                }
                y_start_position_in_str = y_start_position_in_pattern * x_length;
                potential_x = str.substring(0, x_length);
                potential_y = str.substring(y_start_position_in_str, y_start_position_in_str + y_length);
                actual_x_y = composeStringFromPattern(pattern, potential_x, potential_y);
                if (actual_x_y.equals(str)) {
                    result = new String[]{potential_x, potential_y};
                    return result;
                }
            }else{
                calc_length = (x_length * x_count);
                if (calc_length != len) {
                    x_length++;
                    continue;
                }
                potential_x = str.substring(0, x_length);
                actual_x_y = composeStringFromPattern(pattern, potential_x, potential_y);
                if (actual_x_y.equals(str)) {
                    result = new String[]{potential_x};
                    return result;
                }
            }
            x_length++;
        }
        return new String[] {};

    }

    public static String composeStringFromPattern(String pattern, String x, String y){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i)=='x'){
                sb.append(x);
            }else if(pattern.charAt(i)=='y'){
                sb.append(y);
            }
        }
        return sb.toString();
    }

    public static int findYPosition(String str, char target){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==target){
                return i;
            }
        }
        return -1;
    }

    public static int countTargetLetter(char target, String str){
        int counter = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==target){
                counter++;
            }
        }
        return counter;
    }

    public static String flipIt(String str){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(0)=='y'){
                sb.append(String.valueOf('x'));
            }else if(str.charAt(0)=='x'){
                sb.append(String.valueOf('y'));
            }
        }
        return sb.toString();
    }*/
}
