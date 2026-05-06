class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        for(int i=0; i<n; i++){
            int space = m-1;
            for(int j=m-1; j>=0; j--){
                if(boxGrid[i][j] == '*'){
                    space = j-1;
                }
                else if(boxGrid[i][j] == '#'){
                    char temp = boxGrid[i][space];
                    boxGrid[i][space] = '#';
                    boxGrid[i][j] = temp;
                    space--;
                }
            }
        }
        char res[][] = new char[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[j][n-i-1] = boxGrid[i][j];
            }
        }
        return res;
    }
}