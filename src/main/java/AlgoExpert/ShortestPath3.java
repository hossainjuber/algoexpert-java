package AlgoExpert;

import java.util.*;
import java.util.stream.Collectors;

//https://www.algoexpert.io/questions/Shorten%20Path

/*
* 1. Root directory starts with a / (indicates absolute path else relative path)
* 2. / used anywhere else (other than index zero) represents directory separator.
* 3. .. means go back a directory i.e. /foo/bar = /foo
* 4. . represents current directory
* 5. / and . can be repeated without any effect
* 6. /../../.. and / are equivalent
* exmaple: /foo/../test/../test/../foo//bar/./baz
* foo|..|test|..|test|..|foo|bar|.|baz
* foo|..|test|..|test|..|foo|bar|baz
* |foo|bar|baz
* */
class ShortestPath3 {
    public static void main(String[] args){
        //String str = "/foo/../test/../test/../foo//bar/./baz";
        //String str = "/foo/../test/../test/../test/../foo//bar/./baz";
        //String str = "/foo/../test/../test/../foo//bar/./baz";
        //String str = "/foo/bar/baz";
        //String str = "../../foo/bar/baz";
        //String str = "/../../foo/bar/baz";
        //String str = "/../../foo/../../bar/baz";
        //String str = "../../foo/bar/baz";
        //String str = "../../foo/../../bar/baz";
        //String str = "/foo/./././bar/./baz///////////test/../../../kappa";
        String str = "../../foo/../../bar/baz";
        //..|..|foo|..|..|bar|baz
        String result = shortenPath(str);
        System.out.println("The End");
        HashMap<String, String> map = new HashMap<>();
    }

    public static boolean isValidToken(String token){
        return token.length()>0 && !token.equals(".") && !token.equals("");
    }

    public static String shortenPath(String path) {
        if(path==null || path.length()<1) return path;

        boolean isRelative = false;
        if(String.valueOf(path.charAt(0)).equals("/")) isRelative=true;
        String[] array = path.split("/");
        List<String> tokenList = Arrays.asList(array);
        List<String> filterTokens = tokenList.stream().filter(token -> isValidToken(token)).collect(Collectors.toList());

        ArrayList<String> list = new ArrayList<>();
        int jump=0;
        for(int i=filterTokens.size()-1; i>=0; i--){
            if(filterTokens.get(i).equals("..") ){
                jump = countAllConsecutiveDDS(i, filterTokens);
                i=i-(2*jump);
                if(i==0) {
                    list.add(0, filterTokens.get(i));
                    break;
                }
                if(i<0) break;
            }else if(filterTokens.get(i).equals(".") || filterTokens.get(i).equals("")){
                continue;
            }else{
                list.add(0, filterTokens.get(i));
            }
        }

        String result = String.join("/", list);
        if(isRelative) result = "/" + result;
        return result;
    }

    public static int countAllConsecutiveDDS(int startingIdx, List<String> list){
        int counter = 0;
        for(int i=startingIdx; i>=0; i--){
            if(list.get(i).equals("..") ){
                counter++;
            }else{
                return counter;
            }
        }
        return 0;
    }
}




