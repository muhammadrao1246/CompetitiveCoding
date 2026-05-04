class Solution {
    public int arraySign(int[] nums) {
        int o = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0) return 0;
            o = nums[i] < 0 ? -o : o;
        }
        return o;
    }
}