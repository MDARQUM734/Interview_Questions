class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums.length == 0) return 0;
       HashSet<Integer> set = new HashSet<>();
       for(int num : nums) set.add(num);
       int max = 0;
       for(int num : set){
        if(!set.contains(num-1)){
            int count = 1;
            int temp = num;
            while(set.contains(temp + 1)){
                count++;
                temp = temp+1;
            }
            max = Math.max(count,max);
        }
       }
        return max;
    }
}