class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    public void backtrack(int[] candidates, int target,int idx, List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || idx == candidates.length) return;
        list.add(candidates[idx]);
        backtrack(candidates,target-candidates[idx],idx,list,result);
        list.remove(list.size()-1);
        backtrack(candidates,target,idx+1,list,result);
    }
}