class Solution {
    
    // O(n2)
    public boolean canMakeArithmeticProgression(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }

        int diff = arr[1] - arr[0];

        for(int i = 1; i < arr.length-1; i++){
            if(arr[i+1] - arr[i] != diff){
                return false;
            }
        }

        return true;
    }
}