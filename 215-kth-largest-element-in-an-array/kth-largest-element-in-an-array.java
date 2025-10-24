class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) pq.add(num);
        int res = 0;
        while(k>0){
            res=pq.poll();
            k--;
        }
        return res;
    }
}