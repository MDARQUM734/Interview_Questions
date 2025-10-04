class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int maxArea = 0;
        while(i<j){
            int currArea = Math.min(height[i],height[j]) * (j-i);
            maxArea = Math.max(currArea,maxArea);
            if(height[j] > height[i]){
                i++;
            } else{
                j--;
            }
        }
        return maxArea;
    }
}