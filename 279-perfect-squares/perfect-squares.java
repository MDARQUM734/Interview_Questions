class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n, int dp[]){
        if(n == 0) return 0;
        if(dp[n] != -1){
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i*i <=n; i++){
            int currSquare = i*i;
            int curr = 1 + helper(n-currSquare,dp);
            min = Math.min(curr,min);
        }
        dp[n] = min;
        return dp[n];
    }
}