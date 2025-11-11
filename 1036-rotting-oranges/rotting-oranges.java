class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> pq = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    pq.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int dir[][] ={{-1,0},{1,0},{0,1},{0,-1}};
        int minutes = -1;
        while(!pq.isEmpty()){
            int size = pq.size();
            minutes++;
            while(size > 0){
                int curr[] = pq.remove();
                int x = curr[0], y= curr[1];
                for(int d[] : dir){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(nx >= 0 && nx < n && ny>=0 && ny < m && grid[nx][ny]==1){
                        fresh--;
                        grid[nx][ny] = 2;
                        pq.add(new int[]{nx,ny});
                    }
                }
                size--;
            }
        }
        return (fresh == 0) ? minutes : -1;
    }
}