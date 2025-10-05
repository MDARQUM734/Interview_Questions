class Solution {
    public boolean lcs(String str,int i, int j){
        if(i>=j) return true;
        if(str.charAt(i) == str.charAt(j)){
            return lcs(str,i+1,j-1);
        }
        return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int sp = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(lcs(s,i,j)){
                    if(maxLen<j-i+1){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp,sp+maxLen);
    }
}