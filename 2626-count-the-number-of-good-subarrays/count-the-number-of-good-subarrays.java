class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
         long count = 0;
        int left = 0;
        long pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int freq = map.getOrDefault(nums[right], 0);
            pairs += freq;   
            map.put(nums[right], freq + 1);
            while (pairs >= k) {
                count += (n - right);  
                int leftFreq = map.get(nums[left]);
                map.put(nums[left], leftFreq - 1);
                pairs -= (leftFreq - 1); 
                left++;
            }
        }
        return count;
    }
}