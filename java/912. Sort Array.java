
class Main {
    public static void merge(int[] nums, int beg, int end){
        int total = end-beg+1;

        // only run division when beg < end
        if(beg < end){
            int mid = beg+((end - beg)/2);
            merge(nums, beg, mid);
            merge(nums, mid+1, end);

            // performing merge sort
            int i = beg;
            int j = mid+1;
            int[] newArr = new int[total];
            int newIndex = 0;
            while(i <= mid || j <= end){
                // left array exhausted then copy from right one
                if(i > mid){
                    newArr[newIndex++] = nums[j++];
                }
                else if(j > end){
                    newArr[newIndex++] = nums[i++];
                }
                // now comparing if both are index are present
                // at last one
                else if(nums[i] <= nums[j]){
                    newArr[newIndex++] = nums[i++];
                }else{
                    newArr[newIndex++] = nums[j++];
                }
            }
            // copy from first newArr to main array
            for(i = beg; i<=end; i++){
                nums[i] = newArr[(i-beg)];
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        Main.merge(nums, 0, nums.length-1);
        for(int i : nums){
            System.out.println(i);
        }
    }
}