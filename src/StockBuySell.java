public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] aux = new int[prices.length];

        int maxSoFar = 0;
        for(int i = prices.length - 1; i >= 0 ; i--){
            if(prices[i] >= maxSoFar){
                maxSoFar = prices[i];
            }
            aux[i] = maxSoFar;
        }

        int result = 0;
        for(int i = 0 ; i  < prices.length ; i++){
            int profit = prices[i] - aux[i];
            if(profit > result){
                result = profit;
            }
        }

        System.out.println(result);

    }
}
