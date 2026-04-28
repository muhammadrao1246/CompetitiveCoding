class Solution{
    public boolean hasAlternatingBits(int n) {
        if(n <= 1) return true; // edge case
        // converting to binary
        // during conversion we're gonna see whether there are alternating bit sequence or not
        int lastBinary = -1;
        int lastDividableValue = n;
        while(lastDividableValue > 1){
            int remainder = lastDividableValue%2;
            lastDividableValue = lastDividableValue/2;
            if(lastBinary == 0 && remainder == 0) return false;
            else if(lastBinary == 1 && remainder == 1) return false;
            lastBinary = remainder;
        }
        if(lastBinary == lastDividableValue) return false;
        return true;
    }
}