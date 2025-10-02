class Solution {
    public int helper(int n,int m, int dp[][]){
        if(n<0 || m<0) return 0;
        if(dp[n][m] == Integer.MIN_VALUE) return 0;
        if(n==0 && m==0) return 1;
        if(dp[n][m] != -1) return dp[n][m];
        dp[n][m] = helper(n-1,m,dp)+helper(n,m-1,dp);
        return dp[n][m];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        return helper(n-1,m-1,dp);
    }
}