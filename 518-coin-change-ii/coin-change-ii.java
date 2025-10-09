class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
// Step 1: Using coin = 1

// Loop: for (i = 1 to 5)

// i = 1 → dp[1] += dp[0] → 0 + 1 = 1
// → dp = [1, 1, 0, 0, 0, 0]

// i = 2 → dp[2] += dp[1] → 0 + 1 = 1
// → dp = [1, 1, 1, 0, 0, 0]

// i = 3 → dp[3] += dp[2] → 0 + 1 = 1
// → dp = [1, 1, 1, 1, 0, 0]

// i = 4 → dp[4] += dp[3] → 0 + 1 = 1
// → dp = [1, 1, 1, 1, 1, 0]

// i = 5 → dp[5] += dp[4] → 0 + 1 = 1
// → dp = [1, 1, 1, 1, 1, 1]

// ✅ After coin=1: Only 1 way to make each sum (all 1’s).

// Step 2: Using coin = 2

// Loop: for (i = 2 to 5)

// i = 2 → dp[2] += dp[0] → 1 + 1 = 2
// → dp = [1, 1, 2, 1, 1, 1]

// i = 3 → dp[3] += dp[1] → 1 + 1 = 2
// → dp = [1, 1, 2, 2, 1, 1]

// i = 4 → dp[4] += dp[2] → 1 + 2 = 3
// → dp = [1, 1, 2, 2, 3, 1]

// i = 5 → dp[5] += dp[3] → 1 + 2 = 3
// → dp = [1, 1, 2, 2, 3, 3]

// ✅ After coin=2: We can form amounts using 1’s and 2’s.

// Step 3: Using coin = 5

// Loop: for (i = 5 to 5)

// i = 5 → dp[5] += dp[0] → 3 + 1 = 4
// → dp = [1, 1, 2, 2, 3, 4]

// ✅ Final dp = [1, 1, 2, 2, 3, 4]

// dp[5] = 4 → There are 4 combinations to make 5.