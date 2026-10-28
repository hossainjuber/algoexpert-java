package AlgoExpert;

import java.util.*;

public class longestBalancedSubstring {

   public static void main(String[] args){
       //String str = "(())(";
       //String str = "())()(()())";
       String str = "()(()";
       int i = longestBalancedSubstring(str);
       System.out.println("THE END");
   }

	public static int longestBalancedSubstring(String string) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for(int i=0; i<string.length(); i++){
			Character  paren = string.charAt(i);
			if(paren=='('){
				stack.push(paren);
			}else if(paren==')' && !stack.isEmpty()){
				stack.pop();
				count=count+2;
			}else if(paren==')' && stack.isEmpty()){
				heap.add(count);
				count=0;
			}
		}//for
		heap.add(count);
		return heap.peek();
	}

  /*public static int longestBalancedSubstring(String string) {
		int maxLength = 0;
		Stack<Integer> stack = new Stack<>();
		int[] array = new int[string.length()];
		String temp = "";
		int popped_value = 0;
		for(int i=0; i<string.length(); i++){
			temp = String.valueOf(string.charAt(i));
			if(temp.equals("(")){
				stack.push(i);
				array[i] = -1;
			}else {
				if(stack.size() == 0){
					array[i] = -1;
				}else{
					popped_value = stack.pop();
					array[popped_value] = 0;
					array[i] = 2;
				}//else
			}//else
		}//for

	  	int sum1 =0;
	  	int sum2 = 0;
	  	for(int j=0; j<array.length; j++){
	  		if(array[j]>-1){
	  			sum1 += array[j];
			}else{
	  			if(sum1 > sum2){
	  				sum2 = sum1;
				}
	  			sum1 = 0;
			}

	  	}
	  	return sum1 > sum2 ? sum1 : sum2;
  }*/
}
