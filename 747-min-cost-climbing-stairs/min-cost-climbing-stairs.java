class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n]; 
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, dp, 0), helper(cost, dp, 1)); // ya toh first se start karo ya second ab jisme min ho
    }

    public int helper(int[] cost, int[] dp, int idx) {
        if (idx >= cost.length) return 0;
        if (dp[idx] != -1) return dp[idx];
        int oneStep = helper(cost, dp, idx + 1);
        int twoStep = helper(cost, dp, idx + 2);
        dp[idx] = cost[idx] + Math.min(oneStep, twoStep);

        return dp[idx];
    }
}
