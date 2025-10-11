class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int score = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            score += ch-'a'+1;
        }
        int left = 0;
        for(int i=0; i<n-1; i++){
            left += s.charAt(i)-'a'+1;
            if(left == score-left) return true;
        }
        return false;
    }
}