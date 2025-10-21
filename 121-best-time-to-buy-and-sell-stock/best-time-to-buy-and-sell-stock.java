class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(prices[i] > buyPrice){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit,profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}