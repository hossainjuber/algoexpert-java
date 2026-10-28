package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinRewards {

   public static void main(String[] args){
       int[] array = {8,4,2,1,3,6,7,9,5};
       minRewards(array);
   }

     public static int minRewards(int[] scores) {
    // Write your code here.
		if(scores.length==1) return scores[0];
		int[] rewards = new int[scores.length];
		rewards[0]=1;
		for(int i=1; i<scores.length; i++){
			if(scores[i-1]>scores[i]){
				rewards[i]=1;
			}else{
				rewards[i] = rewards[i-1]+1;
			}
		}

		int temp =0;
		int temp2 =0;
		for(int j=scores.length-2; j>0; j--){
			temp =scores[j-1];
			temp2 =scores[j];
			if(scores[j+1]<scores[j]) {
				rewards[j] = Math.max(rewards[j], (rewards[j + 1] + 1));
			}
		}

		if(scores[0]>scores[1]){
			rewards[0]=Math.max(rewards[0], (rewards[1]+1));
		}

		int total=0;
		for(int k=0; k<rewards.length; k++){
			total += rewards[k];
		}
    return total;
  }

}
