class Solution {
    public boolean isEat(int[] piles,int h, int hours){
        long actualHour = 0;
        for(int num : piles){
            actualHour += num/hours;
            if(num % hours != 0){
                actualHour++;
            }
        }
        if(actualHour <= h) return true;
        else return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = 1, high = piles[n-1];
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isEat(piles,h,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}