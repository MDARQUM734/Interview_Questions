class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int []arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=nums[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        while(k>0){
            for(int i=0; i<nums.length; i++){
            int n = pq.peek();
            if(arr[i] == n){
                pq.remove();
                arr[i] = arr[i]*multiplier;
                pq.add(arr[i]);
                break;
            }
        }
        k--;
        }
        return arr;
    }
}