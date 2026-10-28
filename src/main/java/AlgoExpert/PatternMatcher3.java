package AlgoExpert;

public class PatternMatcher3 {

    public static void main(String[] str){
        //String[] result = patternMatcher("yxx", "yomama");
        String[] result = patternMatcher("xxyxxy", "gogopowerrangergogopowerranger");
        //String[] result = patternMatcher("yxyx", "abab");
        //String[] result = patternMatcher("xyx", "thisshouldobviouslybewrong");
        //String[] result = patternMatcher("xxxx", "testtesttesttest");
        //String[] result = patternMatcher("xxyxyy", "baddaddoombaddadoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom");
        //String[] result = patternMatcher("xyxxxyyx", "baddaddoombaddadoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom");
    }

    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        pattern = pattern.toLowerCase();
        if(pattern.charAt(0)=='y'){
            pattern = flipIt(pattern);
        }

        int x_count = countChar(pattern, 'x');
        int y_count = countChar(pattern, 'y');
        int str_length = str.length();
        int x_length = 1;
        int x_length_total = x_count * x_length;
        int y_length = str_length - x_length_total;
        int y_length_total = y_count * y_length;
        while(x_length < str_length /2){
            String x = str.substring(0, x_length);
            String y = create_y(pattern, str, x, y_length);
            String newStr = formulateTotalString(pattern, x, y);
            if(newStr.equals(str)){
                String[] result = new String[]{x, y};
                return result;
            }
            x_length++;
            x_length_total = x_count * x_length;
            y_length = str_length - x_length_total;
            y_length_total = y_count * y_length;
        }//while
        return new String[0];


    }//patternMatcher

    public static String formulateTotalString(String pattern, String x, String y){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<pattern.length(); i++){
            if(pattern.charAt(i)=='x'){
                sb.append(x);
            }else if(pattern.charAt(i)=='y'){
                sb.append(y);
            }
        }//for
        return sb.toString();
    }

    public static int countChar(String str, char ch){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==ch){
                count++;
            }
        }//for
        return count;
    }

    public static String flipIt(String str){
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i<str.length()){
            if(str.charAt(i)=='y'){
                sb.append('x');
            }else if(str.charAt(i)=='x'){
                sb.append('y');
            }
            i++;
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
}
