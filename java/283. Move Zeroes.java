class Solution {
    // a O(n) TC but with O(1) space complexity
    public void moveZeroes(int[] nums) {
        int totalZeros = 0;
        int wi = 0; // writeable index
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0) totalZeros++;
            else {
                nums[wi] = nums[i];
                wi++;
            }
        }
        for(int i = wi; i<nums.length; i++){
            nums[i] = 0;
        }
    }
    // // a O(n) TC but with O(n) space complexity
    // public void moveZeroes(int[] nums) {
    //     int[] ord = new int[nums.length];
    //     int totalZeros = 0;
    //     int oi = 0;
    //     for(int i = 0; i<nums.length; i++){
    //         if(nums[i] == 0) totalZeros++;
    //         else {
    //             ord[oi] = nums[i];
    //             oi++;
    //         }
    //     }
        
    //     for(int i = oi; i<nums.length; i++){
    //         ord[i] = 0;
    //     }
        
    //     for(int i = 0; i<nums.length; i++){
    //         nums[i] = ord[i];
    //     }
    // }
}