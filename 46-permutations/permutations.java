class Solution {
    public void backtrack(int nums[],List<Integer>path,List<List<Integer>> result){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int num : nums){
            if(path.contains(num)) continue;
            path.add(num);
            backtrack(nums,path,result);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), result);
        return result;
    }
}