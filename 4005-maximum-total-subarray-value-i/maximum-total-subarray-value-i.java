class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int l =0;
        int r =0;
        long ans = 0;
        while(r < n){
                min = Math.min(min,nums[r]);
                max = Math.max(max,nums[r]);
            r++;
        }
        int temp = max-min;
        ans = 1L * temp * k;
        return ans;
    }
}