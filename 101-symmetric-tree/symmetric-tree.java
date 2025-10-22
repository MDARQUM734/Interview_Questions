/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p==null || q== null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public TreeNode invert(TreeNode root){
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invert(root.left);
        invert(root.right);
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(isSameTree(root.left,invert(root.right))) return true;
        return false;
    }
}