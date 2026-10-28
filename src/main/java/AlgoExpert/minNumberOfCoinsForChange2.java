package AlgoExpert;

public class minNumberOfCoinsForChange2 {
	public static void main(String[] args){
        //int[] array = {3,4,2,1,2,3,7,1,1,1,3};
        int[] array = {1,5,10};
        int change = 25;
        minNumberOfCoinsForChange(change, array);
   }

  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    if(n<=0) return 0;
    if(denoms==null) return 0;
    int coins = getMinChange(n, denoms, 0);
    return coins;
  }

	public static int getMinChange(int target, int [] denoms, int coins){
		if(target<=0){
			return coins;
		}
		int diff=Integer.MAX_VALUE;
		boolean increment_coint = false;
		for(int i=0; i<denoms.length; i++){
			if(denoms[i] <= target && diff > target-denoms[i]){
				diff = target-denoms[i];
				increment_coint = true;
				//target=diff;
			}
		}//for
        if(increment_coint) coins++;
		return getMinChange(diff, denoms, coins);
	}//getMinChange
}
