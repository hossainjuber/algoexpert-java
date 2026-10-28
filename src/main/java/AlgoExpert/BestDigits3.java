package AlgoExpert;

import java.util.Stack;


/*
* Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
* */
public class BestDigits3 {

   public static void main(String[] args){
       /*String num1 = "462839";
       int numDigits = 2;*/
       String num1 = "19";
       int numDigits = 1;
       String result = bestDigits(num1, numDigits);
       System.out.println(result);
   }

    public static String bestDigits(String number, int numDigits) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<number.length(); i++){
            while(!stack.isEmpty() && number.charAt(i)>stack.peek() && numDigits>0){
                numDigits--;
                stack.pop();
            }//while
            stack.push(number.charAt(i));
        }//for

        while(numDigits>0){
            numDigits--;
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
