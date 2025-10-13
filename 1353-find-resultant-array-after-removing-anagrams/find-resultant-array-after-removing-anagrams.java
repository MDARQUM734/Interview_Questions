class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for(int i=1; i<n; i++){
            char[] prev = words[i-1].toCharArray();
            char[] curr = words[i].toCharArray();
            Arrays.sort(prev);
            Arrays.sort(curr);
            if(!Arrays.equals(prev,curr)){
                list.add(words[i]);
            }
        }
        return list;
    }
}