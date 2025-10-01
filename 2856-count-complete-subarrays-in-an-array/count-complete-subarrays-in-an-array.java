class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        HashSet<Integer> temp = new HashSet<>();
        for(int i=0; i<n; i++){
            temp.add(nums[i]);
        }
        int count = 0;
        int left = 0;
        int m = set.size();
        while(left <= n-m){
            int right = left;
            temp.addAll(set);
            while(right < n && temp.size() != 0){
                if(temp.contains(nums[right])){
                    temp.remove(nums[right]);
                }
                if(temp.size() == 0){
                    count += n-right;
                }
                right++;
            }
            left++;
        }
        return count;
    }
}