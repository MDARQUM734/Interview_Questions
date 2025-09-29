class Solution {
    public int findKthNumber(int m, int n, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int mat[][] = new int[m][n];
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         mat[i][j] = (i+1)*(j+1);
        //     }
        // }
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         pq.add(mat[i][j]);
        //     }
        // }
        // int res = 0;
        // while(k>0){
        //     res = pq.poll(); 
        //     k--;
        // }
        // return res;
        int low = 1, high = m*n;
        while(low < high){
            int mid = low + (high-low)/2;
            if(countLess(mid,m,n) >= k){
                high = mid;
            } else{
                low = mid+1;
            }
        }
        return high;
    }
    public int countLess(int mid, int m, int n){
        int count = 0;
        for(int i=1; i<=m; i++){
            count += Math.min(mid/i,n);
        }
        return count;
    }
}