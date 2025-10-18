class Solution {
    public int minimumDeletions(int[] nums) {
       int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        if (minIdx > maxIdx) {
            int temp = minIdx;
            minIdx = maxIdx;
            maxIdx = temp;
        }
        int front = maxIdx + 1;
        int back = n - minIdx;
        int both = (minIdx + 1) + (n - maxIdx);

        return Math.min(front, Math.min(back, both));
    }
}