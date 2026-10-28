package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
class ShortestPath4 {
    public static void main(String[] args){
        //String str = "/foo/../test/../test/../foo//bar/./baz";
        //String str = "/foo/../test/../test/../test/../foo//bar/./baz";
        //String str = "/foo/../test/../test/../foo//bar/./baz";
        //String str = "/foo/bar/baz";
        //String str = "../../foo/bar/baz";
        //String str = "/../../foo/bar/baz";
        String str = "/../../foo/../../bar/baz";
        //String str = "../../foo/bar/baz";
        //String str = "../../foo/../../bar/baz";
        //String str = "/foo/./././bar/./baz///////////test/../../../kappa";
        //String str = "../../foo/../../bar/baz";
        //..|..|foo|..|..|bar|baz
        String result = shortenPath(str);
        System.out.println("The End");
        HashMap<String, String> map = new HashMap<>();
    }

    public static String shortenPath(String path) {
        boolean isAbsolute = path.charAt(0)=='/';
        String[] tokens = path.split("/");
        List<String> stack = new ArrayList<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("/") || tokens[i].equals(".") || tokens[i].equals("")){
                continue;
            }else if(!isAbsolute && tokens[i].equals("..") && (stack.size()==0 || stack.get(stack.size()-1).equals(".."))){
                stack.add(tokens[i]);
            }else if(tokens[i].equals("..") && stack.size()>0){
                stack.remove(stack.size()-1);
            }else if(isAbsolute && tokens[i].equals("..") && stack.size()==0){
                continue;
            }else {
                stack.add(tokens[i]);
            }
        }

        if(stack.size()==1 && stack.get(0).equals("")) return "/";

        String str = String.join("/", stack);
        if(isAbsolute) {
            return "/" + str;
        }
        return str;
  }

}




