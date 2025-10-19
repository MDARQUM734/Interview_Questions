class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 1 && m ==1) {
            if(matrix[0][0] == target)return true;
            else return false;
        }
        int i =0;
        while(i<n){
            if(matrix[i][0] == target || matrix[i][m-1] == target) return true;
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
            for(int k=0; k<m; k++){
                    if(matrix[i][k] == target) return true;
            }
        }
        i++;
        }
        return false;
            // int n = matrix.length;
        // int m = matrix[0].length;

        // // Single element matrix
        // if (n == 1 && m == 1) {
        //     return matrix[0][0] == target;
        // }

        // int i = 0;
        // while (i < n) {
        //     // Check if target could be in this row
        //     if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
        //         // Search row linearly
        //         for (int k = 0; k < m; k++) {   // k = 0, not i
        //             if (matrix[i][k] == target) return true;
        //         }
        //     }
        //     i++;
        // }

        // return false;
    }
}