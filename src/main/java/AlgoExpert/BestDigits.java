package AlgoExpert;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/*
* Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
* */
public class BestDigits {

   public static void main(String[] args){
       String num1 = "462839";
       int numDigits = 2;
       bestDigits(num1, numDigits);
   }

    public static String bestDigits(String number, int numDigits) {
        char[] array = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(array[0]);
        for(int i=1; i<array.length; i++){
            char arrayNum = array[i];
            while(numDigits>=0 & !stack.isEmpty()){
                int stackNum = stack.peek();
                if(stackNum<arrayNum){
                    stack.pop();
                    stack.push(arrayNum);
                    numDigits--;
                }else{
                    stack.push(arrayNum);
                }
            }//while
        }//for
        return convertStackToString(stack);
    }//bestDigits

    public static String convertStackToString(Stack stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }//while
        return sb.toString();
    }




}
