package AlgoExpert;

import java.util.*;

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
class ShortestPath {
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
        //..|..|foo|..|..|bar|baz
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
            if(tokens[i].equals("..") && isAbsolute && !stack.isEmpty()){
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








    /*public static String shortenPath(String path) {

            String[] array = path.split("/");
            List<String> list = new ArrayList<>();
            String result = "";
            boolean is_absolute = path.charAt(0)=='/' ? true : false;
            boolean is_absolute2 = path.charAt(0)=='/' ? true : false;
            StringBuffer sb = new StringBuffer();
            String token = "";
            for(int i=0; i< array.length; i++){
                token = array[i];
                token = token.trim();
                if(token.equals("..") && list.size()>0 && is_absolute){
                    list.remove(list.size()-1);
                }else if(token.equals("..") && list.size()==0 && is_absolute){
                    continue;
                }else if(token.equals(".") || token.equals("")){
                    continue;
                }else{
                    list.add(token);
                    is_absolute=false;
                }
            }//for

            for(String sub : list){
                sb.append(sub);
                sb.append("/");
            }

            if(is_absolute2){
                result = "/" + sb.toString();
            }else{
                result = sb.toString();
            }
            // Write your code here;
            result = result.substring(0, result.length()-1);
            return result;

  }

  public static String shortenPath2(String path) {
        String[] array = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        boolean is_root = path.charAt(0)=='/' ? true : false;
        String token = "";

        int count = 0;
        if(!is_root){
            for(int i=0; i<array.length; i++){
                if(array[i].equals("..")) {
                    count++;
                }else{
                    break;
                }
            }
        }

        if(!is_root){
            while(count>-1){
                sb.append("../");
            }
        }

        //for(int i=0; i<array.length; i++){
        for(int i=array.length-1; i>=0; i--){
            token = array[i].trim();
            if(token.length()==0 || token.equals(".")){
                continue;
            }else if(token.equals("..")){
                i = i - 1;
                if(i<0) break;
            }else{
                sb.append(token);
                sb.append("/");
            }
        }

        String result = is_root ? "/" + sb.toString().substring(0, sb.toString().length()-1) : sb.toString().substring(0, sb.toString().length()-1);
        return result;


  }*/
}




