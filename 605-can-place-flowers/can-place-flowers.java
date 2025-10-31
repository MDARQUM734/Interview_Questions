class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int count = 0;
        for(int i=0; i<m; i++){
            if(flowerbed[i] == 0){
                int prev = (i == 0) ? 0 : flowerbed[i-1];
                int next = (i == m-1) ? 0 : flowerbed[i+1];

                if(prev == 0 && next == 0){
                    count++;
                    flowerbed[i] = 1; // plant kar deye
                    if(count >= n) return true;
                }
            }
        }
        if(count >= n) return true;
        else return false;
    }
}