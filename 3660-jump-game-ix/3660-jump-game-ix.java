class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int maxPre[] = new int[n];
        int minSuff[] = new int[n];
        maxPre[0] = nums[0];
        minSuff[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            maxPre[i] = Math.max(nums[i],maxPre[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            minSuff[i] = Math.min(nums[i],minSuff[i+1]);
        }
        int ans[] = new int[n];
        ans[n-1] = maxPre[n-1];
        for(int i=n-2; i>=0; i--){
            if(maxPre[i] > minSuff[i+1]){
                ans[i] = ans[i+1];
            }else ans[i] = maxPre[i];
        }
        return ans;
    }
}