class Solution {
    public int height(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void nthLevel(TreeNode root, int n, List<Integer> list){
        if(root == null) return;
        if(n == 1){
            list.add(root.val);
            return;
        }
        nthLevel(root.left,n-1,list);
        nthLevel(root.right,n-1,list);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = height(root) + 1;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        for(int i=1; i<=level; i++){
            List<Integer> list = new ArrayList<>();
            nthLevel(root,i,list);
            res.add(list);
        }
        return res;
    }
}