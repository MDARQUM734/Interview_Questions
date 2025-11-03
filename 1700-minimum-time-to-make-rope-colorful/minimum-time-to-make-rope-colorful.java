class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int m = neededTime.length;
        int cost = 0;
        int max = neededTime[0];
        for(int i=1; i<n; i++){
            char ch = colors.charAt(i-1);
            if(ch == colors.charAt(i)){
                cost += Math.min(neededTime[i],max);
                max = Math.max(neededTime[i],max);
            }else max = neededTime[i];
        }
        return cost;
    }
}