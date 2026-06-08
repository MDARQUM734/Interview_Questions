class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
      int n = nums.length;
      int res[] = new int[n];
      int z = 0;
      int cnt = 0;
      for(int i=0; i<n; i++){
        if(nums[i] < pivot){
            res[z++] = nums[i]; 
        }
        else if(nums[i] == pivot){
            cnt++;
        }
      }
      while(cnt != 0){
        res[z++] = pivot;
        cnt--;
      }
      for(int i=0; i<n; i++){
        if(nums[i] > pivot){
            res[z++] = nums[i];
        }
      }
      return res;
    }
}