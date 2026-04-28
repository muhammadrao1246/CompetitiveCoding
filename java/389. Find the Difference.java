class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char a : s.toCharArray()){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char a : t.toCharArray()){
            map2.put(a, map2.getOrDefault(a, 0) + 1);

            if(map.getOrDefault(a, 0) < map2.getOrDefault(a, 0) || map.getOrDefault(a, 0) == 0){
                return a;
            }
        }
        return ' ';
    }
}