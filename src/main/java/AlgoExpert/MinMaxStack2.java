package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinMaxStack2 {

    public static void main(String[] args){
        MinMaxStack2 mms = new MinMaxStack2();
        mms.push(5);
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        mms.push(7);
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        mms.push(2);
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());
        System.out.println(mms.pop());
        System.out.println(mms.pop());
        System.out.println(mms.getMin());
        System.out.println(mms.getMax());
        System.out.println(mms.peek());

    }

    List<Integer> stack = new ArrayList<>();
	List<Integer> min_stack = new ArrayList<>();
	List<Integer> max_stack = new ArrayList<>();

    public int peek() {
      if(stack.size()==0) return -1;

      return stack.get(stack.size()-1);
    }

    public int pop() {
      if(stack.size()==0) return -1;
			int value = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			if(min_stack.size()>0) {
                if (min_stack.get(min_stack.size()-1) == value) min_stack.remove(min_stack.size()-1);
            }
			if(max_stack.size()>0) {
                if (max_stack.get(max_stack.size()-1) == value) max_stack.remove(max_stack.size()-1);
            }
			return value;
    }

    public void push(Integer number) {
      stack.add(number);
      if(min_stack.size()==0 || min_stack.get(min_stack.size()-1)>number) min_stack.add(number);
      if(max_stack.size()==0 || max_stack.get(max_stack.size()-1)<number) max_stack.add(number);
    }

    public int getMin() {
      if(min_stack.size()==0) return -1;

      return min_stack.get(min_stack.size()-1);
    }

    public int getMax() {
      if(max_stack.size()==0) return -1;

      return max_stack.get(max_stack.size()-1);
    }
}
