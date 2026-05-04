class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length <= 1) return true;
        int state = 0; // 0 neutral | 1 inc | -1 dec
        int recent = nums[0];
        for(int i = 1; i<nums.length; i++){
            // check first
            if(state == 1 && recent > nums[i]) return false;
            else if(state == -1 && recent < nums[i]) return false;

            if(recent < nums[i] && state == 0){
                state = 1;
            }else if(recent > nums[i] && state == 0){
                state = -1;
            }

            recent = nums[i];
        }
        return true;
    }
}