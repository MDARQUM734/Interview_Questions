class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max,arr[i]);
            if(max == i){ // hamare pass 0 to n-1 number he toh hai toh jab hame us boundry tak ka arrya mil gaya to usko internally sort kar denge aur then it works
                count++;
            }
        }
        return count;
    }
}