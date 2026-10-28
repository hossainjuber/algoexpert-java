package AlgoExpert;

//https://www.geeksforgeeks.org/coin-change-dp-7/
public class numberOfWaysToMakeChange {

    public static void main(String[] args){
        //int[] array = {3,4,2,1,2,3,7,1,1,1,3};
        int[] array = {1,5,10};
        int change = 25;
        int result = numberOfWaysToMakeChange(change, array);
        System.out.println(result);
   }

   public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int denom=1; denom<denoms.length; denom++){
            for(int amount=0; amount<ways.length; amount++){
                if(denoms[denom] <= amount){
                    ways[amount] = ways[amount] + ways[amount-denom];
                }
            }
        }
        return -1;
    }

}
