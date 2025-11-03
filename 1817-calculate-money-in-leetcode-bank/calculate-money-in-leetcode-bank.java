class Solution {
    public int totalMoney(int n) {
         int total = 0;
        int mondayStart = 1;
        int day = 0;

        for (int i = 1; i <= n; i++) {
            total += mondayStart + day;
            day++;
            if (day == 7) {
                day = 0;
                mondayStart++;
            }
        }
        return total;
    }
}