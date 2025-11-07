class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
            int size = pq.size();
            double sum = 0;
            for(int i=0; i<size; i++){
                TreeNode temp = pq.poll();
                sum += temp.val;
                if(temp.left != null) pq.add(temp.left);
                if(temp.right != null) pq.add(temp.right);
            }
            result.add(sum/size);
        }
        return result;
    }
}