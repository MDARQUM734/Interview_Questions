class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int red=0, white = 0, blue = 0;
        int i=0;
        while(i<n){
            if(nums[i] == 0) red++;
            else if(nums[i] == 1) white++;
            else blue++;
            i++;
        }
        i=0;
        while(i<red){
            nums[i++] = 0;
        }
        while(i < red+white){
            nums[i++] = 1;
        }
        while(i<n){
            nums[i++]=2;
        }
    }
}