class Solution {
    public int minimumDeletions(String s) {
        int b = 0;
        int a =0;
        int del = 0;
        char[] charArr = s.toCharArray();
        // identifying from the start
        for(int i = 0; i<charArr.length; i++){
            if(charArr[i] == 'b'){
                b++;
            }
            else if(b > 0 && charArr[i] == 'a'){
                // if no a set currently then remove b from behind
                // del a
                b--;
                del++;
            }else{
                a++;
            }
        }  
        
        return del;
    }
}