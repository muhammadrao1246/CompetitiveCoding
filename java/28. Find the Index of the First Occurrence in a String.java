class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        if(haystack.equals(needle)) return 0;
        int n = haystack.length()-needle.length()+1;
        for(int i = 0; i < n; i++){
            String substr = haystack.substring(i, i+needle.length());
            if(substr.equals(needle)) return i;
        }
        return -1;
    }
}