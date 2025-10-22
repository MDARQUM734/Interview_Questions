class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        int m = descriptions[0].length;
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int d[] : descriptions){
            int parentVal = d[0];
            int childVal = d[1];
            int isChild = d[2];

            map.putIfAbsent(parentVal,new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);
            if(isChild == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }
            set.add(childVal);
        }
        TreeNode root = null;
        for(int val : map.keySet()){
            if(!set.contains(val)){
                root = map.get(val);
                break;
            }
        }
        return root;
    }
}