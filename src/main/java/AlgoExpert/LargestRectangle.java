package AlgoExpert;

import java.util.*;

public class LargestRectangle {

    public static void main(String[] str){
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 3, 3, 2, 4, 1, 5, 3, 2));
        int result = largestRectangleUnderSkyline(numbers);
        System.out.println(result);
    }

    public static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
    /*
    1. iterate over the buildings, on each element, take that element/height and
use it to go to left and right and go until you cant go below that height.
    2. calculate the rectangle area and use a reversed priority queue to keep
track of the largest area
    3. after the whole iteration is complete, poll the top element from the q
ueue and return
    */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<buildings.size(); i++){
            int currHeight = buildings.get(i);
            int leftHeight = getLeftHeight(i, buildings);
            int rightHeight = getRightHeight(i, buildings);
            int totalCurrHeight = leftHeight+rightHeight+currHeight;
            if(pq.isEmpty() || pq.peek()<totalCurrHeight){
                pq.add(totalCurrHeight);
            }
        }//for
        return pq.poll();
    }

    public static int getLeftHeight(int i, ArrayList<Integer> buildings){
        int height = 0;
        int currMinHeight = buildings.get(i);
        i = i-1;
        for(int k=i; k>0; k--){
            if(buildings.get(i)<currMinHeight){
                return height;
            }
            height = height + currMinHeight;
        }//for
        return height;
    }

    public static int getRightHeight(int i, ArrayList<Integer> buildings){
        int height = 0;
        int currMinHeight = buildings.get(i);
        i = i+1;
        for(int k=i; k<buildings.size(); k++){
            if(buildings.get(k)<currMinHeight){
                return height;
            }
            height = height + currMinHeight;
        }//for
        return height;
    }

}
