import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)) return true;
        if(s.length() != t.length()) return false;
         // a 26 character that can track and maintain balance w
         // one gonna increment other gonna decremnt thus creating a balance
        HashMap<Character, Integer> counter = new HashMap<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
            if(!counter.containsKey(cs[i])){
                counter.put(cs[i], 1);
            }else{
                counter.put(cs[i], counter.get(cs[i])+1);
            }

            if(!counter.containsKey(ts[i])){
                counter.put(ts[i], -1);
            }else{
                counter.put(ts[i], counter.get(ts[i])-1);
            }
        }

        for(char c : counter.keySet()){
            if(counter.get(c) != 0) return false;
        }
        

        return true;
    }
}