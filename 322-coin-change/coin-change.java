class Solution {
    public int coinChange(int[] coins, int amount) {
         int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with impossible large value
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }
}

// // dp[i] = min number of coins to make amount i
// \U0001fa99 Step 1 — Using coin = 1

// Loop i = 1 → 11

// For each i:

// dp[i] = Math.min(dp[i], dp[i - 1] + 1)


// Updating:

// i=1: dp[1] = min(12, dp[0]+1)=1
// i=2: dp[2] = min(12, dp[1]+1)=2
// i=3: dp[3] = min(12, dp[2]+1)=3
// ...
// i=11: dp[11] = min(12, dp[10]+1)=11


// ✅ After coin=1:

// dp = [0,1,2,3,4,5,6,7,8,9,10,11]


// (each amount made using 1-rupee coins)

// \U0001fa99 Step 2 — Using coin = 2

// Loop i = 2 → 11

// i=2: dp[2] = min(2, dp[0]+1)=1
// i=3: dp[3] = min(3, dp[1]+1)=2
// i=4: dp[4] = min(4, dp[2]+1)=2
// i=5: dp[5] = min(5, dp[3]+1)=3
// i=6: dp[6] = min(6, dp[4]+1)=3
// i=7: dp[7] = min(7, dp[5]+1)=4
// i=8: dp[8] = min(8, dp[6]+1)=4
// i=9: dp[9] = min(9, dp[7]+1)=5
// i=10: dp[10] = min(10, dp[8]+1)=5
// i=11: dp[11] = min(11, dp[9]+1)=6


// ✅ After coin=2:

// dp = [0,1,1,2,2,3,3,4,4,5,5,6]

// \U0001fa99 Step 3 — Using coin = 5

// Loop i = 5 → 11

// i=5: dp[5] = min(3, dp[0]+1)=1
// i=6: dp[6] = min(3, dp[1]+1)=2
// i=7: dp[7] = min(4, dp[2]+1)=2
// i=8: dp[8] = min(4, dp[3]+1)=3
// i=9: dp[9] = min(5, dp[4]+1)=3
// i=10: dp[10] = min(5, dp[5]+1)=2
// i=11: dp[11] = min(6, dp[6]+1)=3


// ✅ Final dp:

// dp = [0,1,1,2,2,1,2,2,3,3,2,3]
