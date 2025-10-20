class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res[] = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int num : nums2){
            while(!st.isEmpty() && st.peek() < num){
                map.put(st.pop(),num);
            }
            st.push(num);
        }
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }
        // int res[] = new int[n];
        for(int i=0; i<n; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}