class Solution {
    Map<TreeNode, Integer> robMap = new HashMap<>();   
    Map<TreeNode, Integer> skipMap = new HashMap<>();  

    public int helper(TreeNode root, boolean inc) {
        if (root == null) return 0;

       if(inc && robMap.containsKey(root)) return robMap.get(root);
       if(!inc && skipMap.containsKey(root)) return skipMap.get(root);

       int res;
       if(inc){
        res = root.val + helper(root.left,false) + helper(root.right,false);
        robMap.put(root,res);
       }else{
        int x = Math.max(helper(root.left,false),helper(root.left,true));
        int y = Math.max(helper(root.right,false),helper(root.right,true));
        res = x+y;
        skipMap.put(root,res);
       }
       return res;
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root, true), helper(root, false));
    }
}
