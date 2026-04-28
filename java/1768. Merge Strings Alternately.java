class Solution {
    public String mergeAlternately(String word1, String word2) {
        String m = "";
        char[] a1 = word1.toCharArray();
        char[] a2 = word2.toCharArray();
        int max = Math.max(a1.length, a2.length);
        for(int i = 0; i <= max; i++){

            if(i < a1.length && i < a2.length ){
                m += a1[i]; 
                m += a2[i];  
            }
            else if(i < a1.length){
                m += a1[i];
            }
            else if(i < a2.length){
                m += a2[i];
            }
        }

        return m;
    }
}