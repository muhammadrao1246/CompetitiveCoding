import java.util.*;
class Solution {
    // O(n2)
    public String longestCommonPrefix(String[] strs) {
        int totalStrings = strs.length;

        if(totalStrings == 0) return "";
        else if(totalStrings == 1) return strs[0];

        // lets find the common prefix
        String common = "";
        for(int pos = 0; pos < 99999999; pos++){
            
            char lastChar = '-';
            for(int i = 0; i< strs.length; i++){
                char[] arr = strs[i].toCharArray();
                // if string length exceed
                if(pos >= arr.length) return common;
                // if string index character does not match with lastChar red
                if(arr[pos] != lastChar && lastChar != '-') return common;

                if(lastChar == '-') lastChar = arr[pos];
            }
            common = common+lastChar;
        }

        return common;
    }
}