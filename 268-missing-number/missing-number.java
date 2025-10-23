class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int missing = -1;
        for(int i=0; i<n; i++){
            if(nums[i] != i){
                missing = i;
                break;
            }
        }
        if(missing == -1) return n;
        return missing;
    }
}