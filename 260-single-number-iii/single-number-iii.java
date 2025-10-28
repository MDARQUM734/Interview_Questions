class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        int diffBit = (xor & -xor);

        int a = 0, b=0;
        for(int num : nums){
            if((num & diffBit) == 0){
                a ^= num; // ek number mil jayega
            }else{
                b ^= num; // ab jaise single number 1 wale me tha waise he ho jayega as ek single number upar se mil gaya
            }
        }
        return new int[]{a,b};
    }
}