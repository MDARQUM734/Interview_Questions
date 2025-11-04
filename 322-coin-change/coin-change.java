class Solution {
    public int helper(int[] coins, int amount,int idx, int dp[][]){
        if(amount == 0) return 0;
        if(coins.length == idx || amount < 0){
            return Integer.MAX_VALUE-1;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int ans1 = 1 + helper(coins,amount-coins[idx],idx,dp);
        int ans2 = helper(coins,amount,idx+1,dp);
        return dp[idx][amount] = Math.min(ans1,ans2);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<amount+1; j++){
                dp[i][j] = -1;
            }
        }
        int ans = helper(coins,amount,0,dp);
        if(ans != Integer.MAX_VALUE-1) return ans;
        else  return -1;
    }
}