class Solution {
    public static boolean dfs(int curr, int graph[][], boolean inRecursion[], boolean visited[]){
        visited[curr] = true;
        inRecursion[curr] = true;
        for(int i=0; i<graph[curr].length; i++){
            int neigh = graph[curr][i];
            if(!visited[neigh] && dfs(neigh,graph,inRecursion,visited)){
                return true;
            }else if(inRecursion[neigh]){
                return true;
            }
        }
        inRecursion[curr] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<v; i++){
            int edge[] = graph[i];
            for(int j=0; j<edge.length; j++){
                adj.get(i).add(edge[j]);
            }
        }
        boolean visited[] = new boolean[v];
        boolean inRecursion[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visited[i]){
                dfs(i,graph,inRecursion,visited);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<v; i++){
            if(!inRecursion[i]){
                result.add(i);
            }
        }
        return result;
    }
}