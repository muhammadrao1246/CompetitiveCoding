class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        int old = Math.abs(x);
        int rev = 0;
        long int_max = Integer.MAX_VALUE;
        while(old >= 1){
                int rem = old%10;
                int quo = old/10;
                long revl = ((long)rev)*10;
                if(revl > int_max) return 0;
                rev = rev*10+rem;
                old = quo;
            }
        
        return isNegative ? -rev:rev;
    }
}