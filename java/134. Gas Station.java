import java.util.Arrays;
class Solution {
    // O(n) solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_surplus = 0; // total diffierence per station
        int surplus = 0; // total difference from last station
        // because only one unique solution is posssible meaning one station is going to allow to go forward which means if a input has no solution than all station are going to givr -ve surplus
        int start = 0; // remembering last station started forward counting surplus
        for(int i = 0; i<gas.length; i++){
            total_surplus += gas[i] - cost[i]; // recording total surplus from each station
            surplus += gas[i] - cost[i]; // recording fromt he current station position
            // if current station surplus goes negative any time that means no way
            if(surplus < 0){
                // then switch to the next station
                start = i+1;
                surplus = 0; // reseting current station surplus
            }
        }

        // if the total_surplus to the last reached station is in negative that means no station have solution
        return total_surplus < 0 ? -1 : start;
    }
    
    // O(n2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0) return -1;
        else if(gas.length == 1) return gas[0] >= cost[0] ? 0 : -1; 
        else if(Arrays.equals(gas, cost)) return 0;
        // running loop over
        for(int i = 0; i<gas.length; i++){
            int fuel = gas[i];
            int nextCost = cost[i];
            if(fuel == nextCost) continue;
            int j = (i+1)%gas.length;
            // System.out.println("At: "+i+"\t"+fuel+"\t"+ nextCost);
                
            while(j!=i){
                fuel = fuel - nextCost;
                if(fuel < 0) break;
                // System.out.println(j+"\t"+fuel+"\t"+ nextCost);
                fuel += gas[j];
                nextCost = cost[j];
                if(fuel >= nextCost) j = (j+1)%gas.length;
            }
            if(i == j) return i;
        }
        return -1;
    }
}