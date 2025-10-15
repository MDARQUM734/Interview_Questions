class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
         int n = nums.size();
        if (n < 2) return 0;
        
        int ans = 0;
        int increasing = 1;       // current run length (in elements)
        int prevIncreasing = 0;   // previous run length
        
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i-1)) {
                increasing++;
            } else {
                // run ended
                // candidate from within this run alone
                ans = Math.max(ans, increasing / 2);
                // candidate from combining with prev run
                ans = Math.max(ans, Math.min(prevIncreasing, increasing));
                
                // shift
                prevIncreasing = increasing;
                increasing = 1;
            }
        }
        
        // final run: also consider it
        ans = Math.max(ans, increasing / 2);
        ans = Math.max(ans, Math.min(prevIncreasing, increasing));
        
        return ans;
    }
}