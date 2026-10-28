package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidIPAddresses {
    public static void main(String[] str){
        //String string = "1921680";
        String string = "255255255255";
        //ArrayList<String> list = validIPAddresses(string);
        System.out.println("The End");
    }
    public static ArrayList<String> validIPAddresses2(String string) {

        if(string==null) return new ArrayList<String>();
        string = string.trim();
        if(string.length()>12){
            return new ArrayList<>();
        }

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        String ip = "";
        for(int i=0; i<string.length(); i++){
            if(i+1 > string.length()) continue;
            //list.add( i+1<string.length() ? string.substring(0, i+1) : string.substring(0, i) );
            list.add( string.substring(0, i+1) );
            for(int j=i+1; j<string.length(); j++){
                if(j+1 > string.length() || i+1>string.length()) continue;
                list.add(string.substring(i+1, j+1) );
                for(int k=j+1; k<string.length(); k++){
                    if(j+1 > string.length() || k+1>string.length()) continue;
                    list.add( string.substring(j+1, k+1) );
                    list.add( string.substring(k+1) );
                    ip = getValidIPAddress(list);
                    if(ip!=null && ip.length() > 0){
                        result.add(ip);
                    }
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                }//for
                list.remove(list.size()-1);
            }//for
            list.remove(list.size()-1);
        }//for

        return result;
    }

    public static String getValidIPAddress(List<String> list){
        /* Rules:
         * 1.
         * 2. each segment should be between 1 - 255 inclusive
         * 3. no leading zeros
         * 4. return empty list if no valid one can be formed
         * 5. no empty section
         * 6.
         */
        Integer integer = null;
        StringBuffer sb = new StringBuffer();
        String str = "";
        for(int i=0; i<list.size(); i++){
            str = list.get(i).trim();
            if(str.length()==0 || str.length()>3) return null;
            integer = Integer.valueOf(str);
            if(integer<0 || integer >255) return null;
            if(str.charAt(0)=='0' && str.length()>1) return null;
            sb.append(str);
            if(i<list.size()-1)sb.append(".");
        }
        return sb.toString();
    }

    public static boolean isValid(String str){
        if(str==null || str.length()<1){
            return false;
        }
        Integer ip = Integer.parseInt(str);
        if(ip<0 || ip>256){
            return false;
        }

        return true;
    }//is valid


    }
