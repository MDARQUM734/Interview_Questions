class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0; i<m; i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0) map.remove(ch);
            } else return false;
        }
        if(map.size() == 0) return true;
        else return false;
    }
}