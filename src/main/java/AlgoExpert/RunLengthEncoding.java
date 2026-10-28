package AlgoExpert;

import java.util.Stack;

//https://www.algoexpert.io/questions/Run-Length%20Encoding
public class RunLengthEncoding {

    public static void main(String[] str){
        String s1 = "CAAAAAAAAAAAAAAAAAAAAA";
        String s = runLengthEncoding(s1);
    }

     public static String runLengthEncoding(String string) {
    // Write your code here.
    StringBuffer sb = new StringBuffer();
    int counter = 1;
    int division=0;
    int remainder=0;
    String s1 = "";
    String s2 = "";
    int i=0;
    for(i=1; i<=string.length()-1; i++){
        //s1 = string.charAt(i-1);
        if(string.charAt(i-1)!=string.charAt(i)){
            sb = helper(string, sb, i, counter);
            counter=1;
        }else{
            counter++;
        }
    }
    if(counter>0){
        //sb.append(String.valueOf(counter));
        //sb.append(String.valueOf(string.charAt(string.length()-1)));
        sb = helper(string, sb, i, counter); 
    }
    return sb.toString();
  }

  public static StringBuffer helper(String string, StringBuffer sb, int i, int counter){
      int division = 0;
      int remainder = 0;

        if(counter>9){
          division = counter / 9;
          remainder = counter % 9;
          if(division>0){
              while(division>0){
                  sb.append(String.valueOf(9));
                  sb.append(String.valueOf(string.charAt(i-1)));
                  division = division-1;
              }
              sb.append(String.valueOf(remainder));
              sb.append(String.valueOf(string.charAt(i-1)));
          }else{
              //sb.append(String.valueOf(counter));
              sb.append(String.valueOf(string.charAt(i-1)));
          }
      }else{
          sb.append(String.valueOf(counter));
          sb.append(String.valueOf(string.charAt(i-1)));
      }
        return sb;
  }

}
