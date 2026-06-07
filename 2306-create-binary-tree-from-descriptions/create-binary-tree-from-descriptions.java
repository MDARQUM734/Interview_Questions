class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int d[] : descriptions){
            int par = d[0];
            int child = d[1];
            int isLeft = d[2];
            map.putIfAbsent(par,new TreeNode(par));
            map.putIfAbsent(child,new TreeNode(child));
            TreeNode parentNode = map.get(par);
            TreeNode childNode = map.get(child);
            if(isLeft == 1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
            set.add(child);
        }
        for(int d[]:descriptions){
            int num = d[0];
            if(!set.contains(num)){
                return map.get(num);
            }
        }
        return null;
    }
}