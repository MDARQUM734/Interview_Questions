class Solution {
    private static final int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length+1;
        List<Integer> graph[] = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        Queue<int[]> q = new LinkedList<>();
        boolean visited[] = new boolean[n+1];
        q.add(new int[]{1,0});
        visited[1] = true;
        int maxDepth = 0;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0];
            int depth = curr[1];
            maxDepth = Math.max(maxDepth,depth);
            for(int neigh:graph[node]){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.add(new int[]{neigh,depth+1});
                }
            }
        }
        return modPower(2,maxDepth-1);
    }
    public int modPower(long base,int pow){
        long result = 1;
        while(pow > 0){
            if((pow & 1) ==1){
                result = (result*base)%MOD;
            }
            base = (base*base)%MOD;
            pow >>= 1;
        }
        return (int)result;
    }
}