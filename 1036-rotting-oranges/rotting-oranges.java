class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int num = 2;
        boolean changed = false;
        while(true){
            changed = false;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j] == num){
                        if (i > 0 && grid[i-1][j] == 1) { 
                            grid[i-1][j] = num + 1; 
                            changed = true; }
                        if (i < n-1 && grid[i+1][j] == 1) { 
                            grid[i+1][j] = num + 1; 
                            changed = true; }
                        if (j > 0 && grid[i][j-1] == 1) { 
                            grid[i][j-1] = num + 1; 
                            changed = true; }
                        if (j < m-1 && grid[i][j+1] == 1) { 
                            grid[i][j+1] = num + 1; 
                            changed = true; }
                    }
                }
            }
            if(!changed) break;
            else num++;
        }
        for (int[] row : grid)
        for (int cell : row)
            if (cell == 1) return -1;
        return num-2;
    }
}