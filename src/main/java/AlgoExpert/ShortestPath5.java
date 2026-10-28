package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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
class ShortestPath5 {
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
        //String str = "../../foo/../../bar/baz";
        //..|..|foo|..|..|bar|baz
        String str = "../../foo/bar/baz";
        String result = shortenPath(str);
        System.out.println("The End");
        HashMap<String, String> map = new HashMap<>();
    }

    public static String shortenPath(String path) {
        // Write your code here;
        Stack<String> stack = new Stack<>();
        boolean isAbsolute=false;
        if(path.charAt(0)=='/'){
            isAbsolute=true;
            //stack.push("");
        }


        String[] tokens = path.split("/");
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(tokens[i].equals(".") || tokens[i].equals("") ){
                //|| tokens[i].equals("/") || tokens[i].equals("//")){
                continue;
            }else{
                stack.push(tokens[i]);
            }
        }//for

        String result =  String.join("/", stack);
        if(isAbsolute && result.charAt(0)!='/'){
            return "/"+result;
        }
        return result;
    }

    public static String shortenPath2(String path) {
        if(path==null || path.length()==0) return path;

        boolean isAbsolute = false;
        if(path.charAt(0)=='/'){
            isAbsolute = true;
        }
        String[] dirs = path.split("/");

        Stack<String> stack = new Stack<>();
        for(int i=0; i<dirs.length; i++){

            if(dirs[i].equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(dirs[i].equals(".") || dirs[i].equals("")){
                continue;
            }else{
                stack.push(dirs[i]);
            }
        }//for

        StringBuffer sb = new StringBuffer();

        String result = String.join("/", stack);

        if(isAbsolute){
            result = "/" + result;
        }
        return result;
    }

}




