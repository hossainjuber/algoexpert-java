package AlgoExpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NonConstructibleChange {

   public static void main(String[] args){
   	   int[] coins = {1,1,2,3,5,7,22};
	   nonConstructibleChange(coins);
   }

	public static int nonConstructibleChange(int[] coins) {
		Arrays.sort(coins);
		int currentChangeCreated = 1;
		for(int coin : coins){
			System.out.println("currentChangeCreated + i: " + currentChangeCreated );
			if(coin > currentChangeCreated ){
				return currentChangeCreated;
			}
			currentChangeCreated += coin;
		}//for

		return currentChangeCreated;
	}





}
