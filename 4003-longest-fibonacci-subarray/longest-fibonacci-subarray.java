class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i=0, j= 2, max = 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        while(i<n && j<n){
            int cnt = 0;
            while(j<n && (nums[j]==nums[j-1]+nums[j-2])){
                j++;
            }
            cnt = j-i;
            max = Math.max(cnt,max);
            i = j-1;
            j++;
        }
        return max;
    }
}