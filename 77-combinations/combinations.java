class Solution {
    public void helper(int start,int n,int k, List<List<Integer>> result,List<Integer> curr){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start; i<=n; i++){
            curr.add(i);
            helper(i+1,n,k,result,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1,n,k,result,new ArrayList<>());
        return result;
    }
}