package AlgoExpert;

import java.util.Stack;
import java.util.stream.Collectors;


/*
* Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
* */
public class BestDigits2 {

   public static void main(String[] args){
       /*String num1 = "462839";
       int numDigits = 2;*/
       String num1 = "321";
       int numDigits = 1;
       String result = bestDigits(num1, numDigits);
       System.out.println(result);
   }

    public static String bestDigits(String number, int numDigits) {
        Stack<Character> stack = new Stack<>();
        char[] array = number.toCharArray();
        int i=1;
        stack.push(number.charAt(0));
        while(i<array.length && stack.size()<number.length()-numDigits){
            //for(int i=1; i<array.length; i++){
            char stackPeek = stack.isEmpty()? (char) -1 :stack.peek();
            char currChar = array[i];
            int peek = stackPeek - '0';
            int curr = currChar - '0';
            if(!stack.isEmpty() && peek<=curr && numDigits>0){
                stack.pop();
                stack.push(currChar);
                numDigits--;
            }else if(!stack.isEmpty() && peek>=curr && numDigits>0){
                stack.push(currChar);
                //numDigits--;
            }else{
                stack.push(currChar);
            }
            i++;
        }//while
        //return stack.stream().map(Object::toString).collect(Collectors.joining(""));
        //return stack.stream().collect(Collectors.joining(""));
        return convertStackToString(stack);
    }//bestDigits

    public static String convertStackToString(Stack stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }//while
        return sb.reverse().toString();
    }




}
