class Solution {
    public int[] plusOne(int[] digits) {
        // First Case
        if(digits.length == 0) return digits;
        // Second Case
        int lastIndex = digits.length-1;
        if(digits[lastIndex] < 9) {
            digits[lastIndex]++;
            return digits;
        }

        // 3rd Case
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--){
            int n = digits[i]+carry;
            if(n == 10) {
                digits[i] = 0;
            }else{
                digits[i] = n;
                // if after adding carry '1' to an element doesn't produce 10 then stop, update and return
                return digits;
            }
        }
        
        // if still carry is 1 remaining that means create new array
        int[] ne = new int[digits.length+1];
        ne[0] = 1;
        for(int i = 1; i < ne.length; i++){
            ne[i] = digits[i-1];
        }
        return ne;
    }
    // A GENERIC BASIC UNDERSTANDING SOLUTION A NAIVE BUT NOT PRACTICAL FOR LONG DATASETS
    // public int[] plusOne(int[] digits) {
    //     if(digits.length == 0) return new int[]{};
    //     int lastIndex = digits.length-1;
    //     if(digits[lastIndex] < 9) {
    //         digits[lastIndex]++;
    //         return digits;
    //     }
    //     int power = 0;
    //     long num = 0;
    //     for(int i = digits.length - 1; i>=0; i--){
    //         num += Math.pow(10,power++)*digits[i];
    //     }
    //     // new num
    //     num++; // 999 + 1 = 1000
    //     // 888/1000 = 0.888 | 1000/1000 = 0
    //     int newPower = (num/Math.pow(10, power)) == 1.00f ? power : power-1;
    //     // System.out.println(newPower);
    //     int newLen = newPower >= power ? digits.length+1 : digits.length;

    //     int[] n = new int[newLen];
    //     int i = 0;
    //     for(int p = newPower; p >= 0; p--){
    //         long dec = (long)Math.pow(10, p);
    //         int entry = (int)(num/dec);
    //         num = num-(dec*entry);
    //         n[i] = entry;
    //         i++;
    //     }
    //     return n;
    // }
}