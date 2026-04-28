class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn == 0) return Arrays.asList(new String[]{"0:00"});
        else if(turnedOn > 8) return Arrays.asList(new String[]{});
        List<String> possibleStates = new ArrayList<>();

        // we dont need to think in bits
        // just think in decimals and move
        for(int hours = 0; hours <= 11; hours++){
            // Integer.bitCount return the number of 1's in the binary representation of decimal value
            // which means how many leds will going to be ON
            for(int min = 0; min <= 59; min++){
                // 0,1 -> 1 | 2,3 -> 2 | 4,5,6,7 -> 3 | 8,9,10,11 -> 4
                int hourBitRepresentation = Integer.bitCount(hours);
                // 0,1 -> 1 | 2,3 -> 2 | 4,5,6,7 -> 3 | 8,9,10,11 -> 4
                int minBitRepresentation = Integer.bitCount(min);
                if(hourBitRepresentation+minBitRepresentation == turnedOn){
                    String minRep = (min+"").length() == 1 ? "0"+min : min+"";
                    possibleStates.add(hours+":"+minRep);
                }
            }
        }
        // running
        return possibleStates;
    }
}