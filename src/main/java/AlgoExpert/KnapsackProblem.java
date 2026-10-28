package AlgoExpert;

import java.util.*;

public class KnapsackProblem {

    public static void main(String[] args){
       int[][] matrix = {{1,2},{4,3},{5,6},{6,7} };
       int capacity = 10;

       //int[][] matrix = {{1,2},{4,3},{5,6},{6,9} };
       //int capacity = 11;

       List<List<Integer>> result = knapsackProblem(matrix, capacity);
       System.out.println("THE END");
   }

  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    List<Integer> capacity_list = new ArrayList<>();
    capacity_list.add(capacity);
    result.add(capacity_list);
    if(items.length==1){
        list.add(0);
        list.add(1);
        result.add(list);
        return result;
    }
    int weight1=0;
    int value1=0;
    int weight=1;
    int value=0;
    Stack<Integer> weight_stack = new Stack<>();
    Stack<Integer> value_stack = new Stack<>();

    Set<Integer> set = new HashSet<>();
    for(int i=0; i<items.length; i++){
        set = new HashSet<>();
        set.add(i);
        if(set.size()==items.length-1) break;
        for(int j=0; j<items.length; j++){
            if(set.size()==items.length-1) break;

            if(set.contains(j)) continue;
            weight1 = getTotalFromSet(set, items, 1) + items[j][weight];
            value1 = getTotalFromSet(set, items, 0) + items[j][value];
            if(weight1 <=capacity){
                set.add(j);
                if(!weight_stack.isEmpty() && weight_stack.peek()<weight1){
                    weight_stack.pop();
                }
                weight_stack.push(weight1);

                if(!value_stack.isEmpty() && value_stack.peek()<value1){
                    value_stack.pop();
                }
                value_stack.push(value1);
            }

            if(j==items.length-1) {
                j = 0;
            }
        }
    }//for
    list.add(weight_stack.pop());
    list.add(value_stack.pop());
    result.add(list);
    return result;
  }

  public static int getTotalFromSet(Set<Integer> set, int[][] items, int value_or_weight_index){
        int result = 0;
        for(int i=0; i<set.size(); i++){
            result += items[i][value_or_weight_index];
        }
        return result;
  }
}
