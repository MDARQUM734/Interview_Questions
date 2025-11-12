class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int p[] : prerequisites){
            adj[p[1]].add(p[0]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i,vis,stack,adj)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(int curr, boolean vis[],boolean stack[], List<Integer>[] adj){
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<adj[curr].size(); i++){
            int edge = adj[curr].get(i);
            if(!vis[edge]){
                if(dfs(edge,vis,stack,adj)) return true;
            }else if(stack[edge]){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
}