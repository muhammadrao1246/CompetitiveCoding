class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int size = 2; size <= s.length(); size++){
            String sub = s.substring(0,size);
            int divisions = s.length()/sub.length();
            if(s.length()%sub.length() != 0) continue;

            int count = 1;
            if(count*size+size > s.length()) return false;
            while(s.substring(count*size, (count*size)+size).equals (sub)){
                count++;
                if(count*size+size > s.length()) break;
            }
            if(count == divisions) return true;
        }

        return false;
    }
}