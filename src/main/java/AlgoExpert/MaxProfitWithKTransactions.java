package AlgoExpert;

public class MaxProfitWithKTransactions {
    //https://www.algoexpert.io/questions/Max%20Profit%20With%20K%20Transactions
    public static void main(String[] str){
        int[] stock_prices = {5, 11, 3, 50, 60, 90};
        int k = 2;
        int max_profit = maxProfitWithKTransactions2(stock_prices, k);
        System.out.println("max profit: "+max_profit);

    }
    public static int maxProfitWithKTransactions2(int[] prices, int k) {
        int new_K = k+1;
        int[][] profit = new int[new_K][prices.length];

        for(int i=0; i<profit[0].length; i++){
            profit[0][i] = 0;
        }

        int max_profit = Integer.MIN_VALUE;
        int temp = 0;
        for(int i=1; i<profit.length; i++){
            max_profit = Integer.MIN_VALUE;
            for(int j=1; j<prices.length; j++){
                    max_profit = Math.max(max_profit, profit[i-1][j-1]-prices[j-1]);
                    temp = Math.max(profit[i][j-1], max_profit + prices[j]);
                    profit[i][j] = temp;
                    //max_profit
            }

        }
        return temp;
    }
}
