class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sumLeft[] = new int[n];
        int sumRight[] = new int[n];
        sumLeft[0] = nums[0];
        sumRight[n-1]=nums[n-1];
        for(int i=1; i<n; i++){
            sumLeft[i] = nums[i]+sumLeft[i-1];
        }
        for(int i=n-2; i>=0; i--){
            sumRight[i] = nums[i] + sumRight[i+1];
        }
        for(int i=0; i<n; i++){
            if(sumLeft[i] == sumRight[i]) return i;
        }
        return -1;
    }
}