class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueResults = new HashSet<>();
        backtrack(candidates,target,0,new ArrayList<>(),result,uniqueResults);
        return result;
    }
    public void backtrack(int[] candidates, int target,int idx, List<Integer> list,List<List<Integer>> result,Set<List<Integer>> uniqueResults){
        if(target == 0){
            if(!uniqueResults.contains(list)){
                uniqueResults.add(new ArrayList<>(list));
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(target < 0 || idx == candidates.length) return;
        list.add(candidates[idx]);
        backtrack(candidates,target-candidates[idx],idx+1,list,result,uniqueResults); // for taking one value once 
        backtrack(candidates,target-candidates[idx],idx,list,result,uniqueResults); // for taking same value again and again
        list.remove(list.size()-1);
        backtrack(candidates,target,idx+1,list,result,uniqueResults);
    }
}