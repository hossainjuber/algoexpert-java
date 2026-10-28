package AlgoExpert;

import java.util.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] str){
        //int[] array = new int[]{5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        int[] array = new int[]{10, 22, 9, 33, 21, 61, 41, 60, 80};
        List<Integer> list = longestIncreasingSubsequence(array);
        System.out.println("The End");
    }

    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        // Write your code here.
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        ArrayList<Integer> list;
        for(int i=0; i<array.length; i++){
            list  = expandLeftAndRight(i, array);
            map.put(list.size(), list);
            pq.add(list.size());
        }
        return map.get(pq.poll());
    }

    public static ArrayList<Integer> expandLeftAndRight(int i, int[] array){
        ArrayList<Integer> list = new ArrayList<>();
        int k=i;
        int currNum = array[k];

        list.add(currNum);
        while(k>0){
            int prevNum = array[k-1];
            if(prevNum<currNum){
                list.add(prevNum);
                currNum = prevNum;
            }
            k--;
        }
        k=i;
        currNum = array[k];
        int nextNum;
        while(k<array.length-1){
            nextNum = array[k+1];
            if(currNum<nextNum){
                list.add(nextNum);
                currNum = nextNum;
            }
            k++;
        }
        Collections.sort(list);
        return list;
    }

}
