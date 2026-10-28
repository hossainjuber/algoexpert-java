package AlgoExpert;

public class minNumberOfCoinsForChange {
        public static void main(String[] args){
        //int[] array = {3,4,2,1,2,3,7,1,1,1,3};
        int[] array = {1,5,10};
        int change = 2;
        minNumberOfCoinsForChange(change, array);
   }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int change = n;
        int counter = 0;
        boolean out = false;
        while(change>=0 || !out){
            for(int i=denoms.length-1; i>=0; i--){
                if(denoms[i]>change){
                    continue;
                }else{
                    if(change % denoms[i]>0){
                        counter = change / denoms[i];
                        change = change % denoms[i];
                    }else{
                        out=true;
                        return counter+change;
                    }
                }
            }
        }
        return counter;
    }
}
