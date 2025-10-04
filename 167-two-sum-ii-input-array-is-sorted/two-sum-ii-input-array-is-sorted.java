class Solution {
    public int binarySearch(int[] numbers,int start,int end, int target){
        while(start <= end){
        int mid = start + (end-start)/2;
        if(numbers[mid] == target) return mid;
        else if(numbers[mid] > target) end = mid-1;
        else start = mid+1;
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0; i<n; i++){
            int newTar = target-numbers[i];
            int idx = binarySearch(numbers,i+1,n-1,newTar);
            if(idx != -1){
                return new int[]{i+1,idx+1};
            }
        }
        return new int[]{-1,-1};
    }
}