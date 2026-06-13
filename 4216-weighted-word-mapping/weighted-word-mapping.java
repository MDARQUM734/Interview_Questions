class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder str = new StringBuilder();
        for(String s : words){
            int sum = 0;
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                sum = (sum + weights[ch-'a'])%26;
            }
            str.append((char)('z'-sum));
        }
        return str.toString();
    }
}