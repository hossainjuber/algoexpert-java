package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaircaseTraversal {

    public static void main(String[] args){
        int ways = staircaseTraversal(4, 3);
    }
    
  public static int staircaseTraversal(int height, int maxSteps) {
    	height = height+1;
    	int[] ways = new int[height];
		ways[0] = 1;
		ways[1] = 1;
		int a = 0;
		int step_value = 0;
		for(int i=2; i<height; i++){
			//ways[i] = ways[i-1] + ways[i-2];
			a = 1;
			step_value = 0;
			while(a<=maxSteps && i-a>=0){
				step_value+=ways[i-a];
				a++;
			}
			ways[i] = step_value;
		}

		int count_ways = 0;
		//getting the index of maxSteps below the height
		int maxStep_below_height = height - maxSteps -1;
		for(int j=height-2; j>=maxStep_below_height; j--){
			count_ways += ways[j];
		}
		return count_ways;
  }

}
