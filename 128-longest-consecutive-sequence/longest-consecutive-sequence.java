class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.add(num);

        int prev = pq.poll();
        int count = 1;
        int max = 1;

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (curr == prev + 1) {
                count++;
            } else if (curr != prev) {
                count = 1;
            }
            max = Math.max(max, count);
            prev = curr;
        }

        return max;
    }
}