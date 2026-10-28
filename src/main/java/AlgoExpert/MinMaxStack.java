package AlgoExpert;

import java.util.Stack;

public class MinMaxStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    public int peek() {
        return stack.peek();
    }

    public int pop() {
        int value = stack.pop();
        if(getMin()==value) minStack.pop();
        if(getMax()==value) maxStack.pop();
        return value;
    }

    public void push(Integer number) {
        stack.push(number);
        if(number <= getMin()){
            minStack.push(number);
        }
        if(number>=getMax()){
            maxStack.push(number);
        }
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return minStack.peek();
        }
    }

    public int getMax() {
        if(maxStack.isEmpty()){
            return Integer.MIN_VALUE;
        }else{
            return maxStack.peek();
        }
    }
}
