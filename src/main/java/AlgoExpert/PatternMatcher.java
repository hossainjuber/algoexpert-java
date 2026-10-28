package AlgoExpert;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatternMatcher {

    public static void main(String[] str){
        //String[] result = patternMatcher("xxyxxy", "gogopowerrangergogopowerranger");
        //String[] result = patternMatcher("yxyx", "abab");
        //String[] result = patternMatcher("xyx", "thisshouldobviouslybewrong");
        String[] result = patternMatcher("xxxx", "testtesttesttest");
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    public static String[] get_pattern_constructed(String str, String pattern, int x_length, int y_length){
        StringBuffer sb = new StringBuffer();


        //we know that the str starts with x, lets construct the x first
        String x_constructed = str.substring(0, x_length);
        String y_constructed = "";
        //now lets construct y:
        int y_stat_index = 0;
        for(int i=0; i<pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                y_stat_index = y_stat_index + x_length;
            }else{
                y_constructed = str.substring(y_stat_index, y_stat_index+y_length);
                break;
            }
        }//for

        for(int i=0; i<pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                sb.append(x_constructed);
            }else{
                sb.append(y_constructed);
            }
        }

        return new String[] {x_constructed, y_constructed, sb.toString()};
    }

    //pattern: xxyxxy
    //str: gogopowerrangergogopowerranger
    public static String[] patternMatcher(String pattern, String str) {
        boolean switched = false;
        if(pattern.startsWith("y")){
            switched = true;
            pattern = pattern.replace('y', 'z');
            pattern = pattern.replace('x', 'y');
            pattern = pattern.replace('z', 'x');
        }
        // Write your code here.
        char[] pattern_array = pattern.toCharArray();
        Map<Character, Integer> frequency_in_pattern_map = getFrequencyMap(pattern);

        String x;
        String y;
        String[] x_y_constructed = {};
        int y_length = 0;
        Integer x_freq = frequency_in_pattern_map.get('x');
        Integer y_freq = frequency_in_pattern_map.get('y');

        for(int i=0; i<str.length(); i++){
            //assuming length of x is 1
            x = String.valueOf(str.substring(0, i+1));
            if(y_freq==null){
                y_freq = 0;
            }else{
                y_length = ( str.length() - (x_freq * x.length()) ) / y_freq;
            }

            if(y_length<0) return new String[]{};
            x_y_constructed = get_pattern_constructed(str, pattern, x.length(), y_length);
            if(str.equals(x_y_constructed[2])){
                if(switched){
                    return new String[] {x_y_constructed[1], x_y_constructed[0]};
                }else{
                    return new String[] {x_y_constructed[0], x_y_constructed[1]};
                }
            }
        }

        return null;

    }

    public static Map<Character, Integer> getFrequencyMap(String pattern){
        Map<Character, Integer> frequency =
                pattern.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        return frequency;
    }
}
