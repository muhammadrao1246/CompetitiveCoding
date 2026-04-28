// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void merge(int[] nums, int beg, int end){
        int total = end-beg+1;

        // only run division when beg < end
        if(beg < end){
            int mid = beg+((end - beg)/2);
            merge(nums, beg, mid);
            merge(nums, mid+1, end);

            // performing merge sort
            int i = beg;
            int j = mid+1;
            int[] newArr = new int[total];
            int newIndex = 0;
            while(i <= mid || j <= end){
                // left array exhausted then copy from right one
                if(i > mid){
                    newArr[newIndex++] = nums[j++];
                }
                else if(j > end){
                    newArr[newIndex++] = nums[i++];
                }
                // now comparing if both are index are present
                // at last one
                else if(nums[i] <= nums[j]){
                    newArr[newIndex++] = nums[i++];
                }else{
                    newArr[newIndex++] = nums[j++];
                }
            }
            // copy from first newArr to main array
            for(i = beg; i<=end; i++){
                nums[i] = newArr[(i-beg)];
            }
        }
    }
    public static boolean isPrimeNumber(int num){
        if(num <= 1) return false;
        if (num == 2 || num == 3) return true;
        for(int i = 2; i< num; i++){
            // if can be divisible by other numbers
            if(num%i == 0) return false;
        }
        return true;
    }
    
    public static String DecimalToBinary(int num){
        String binaryStr = "";
        int lastDivisibleNumber = num;
        while(lastDivisibleNumber > 1){
            int remainder1or0 = lastDivisibleNumber%2; 
            lastDivisibleNumber = lastDivisibleNumber/2;
            binaryStr = remainder1or0 + binaryStr;
        }
        binaryStr = lastDivisibleNumber + binaryStr;;
        return binaryStr;
    }
    
    public static int GreatestCommonDivisor(int num1, int num2){
        int greatestCommonDivisor = 1;
        int minNumber = num1 > num2 ? num1 : num2;
        for(int i = 2; i<= minNumber; i++){
            if( num1 % i == 0 && num2 % i == 0){
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }
    
    public static String FindCommonFactors(int num1, int num2){
        String commonFactors = "";
        int minNumber = num1 > num2 ? num1 : num2;
        for(int i = 1; i<= minNumber; i++){
            if( num1 % i == 0 && num2 % i == 0){
                commonFactors += i +"\n"; 
            }
        }
        return commonFactors;
    }
    
    public static int HighestCommonFactor(int num1, int num2){
        int minNumber = num1 > num2 ? num1 : num2;
        for(int i = minNumber; i>= 2; i--){
            if( num1 % i == 0 && num2 % i == 0){
                return i; 
            }
        }
        return 1;
    }
    
    public static int[] TwoSum(int[] nums, int target){
        // target = two index + number
        HashMap<Integer,Integer> counter = new HashMap<>();
        // for(int i = 0; i< size(nums); i++){
        //     // checking whether target - nums[i] exist in counter or not
        //     int toBeSearched = target - nums[i];
        //     if(counter.containsKey(toBeSearched)){
        //         // if found that the subtracted value is also in counter then return both indexes
        //         int indexOfToBeSearched = counter.get(toBeSearched);
        //         return new int[]{indexOfToBeSearched, i};
        //     }
            
        //     // we should store the current index value in hashmap
        //     if(!counter.containsKey(nums[i])){
        //         counter.put(nums[i], i);
        //     }
        // }
        return new int[]{};
    }
    public static int ReversingDigit(int num){
        int old = num;
        int rev = 0;
        while(old>=1){
            int rem = old%10; 
            int quo = old/10;
            rev = rev*10+rem;
            old = quo;
        }
        
        return rev;
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> occurMap = new HashMap<>();
        for(int n:nums){
            if(occurMap.keySet().contains(n)){
                int currOccur = occurMap.get(n);
                occurMap.put(n, currOccur+1);
                if(currOccur >= nums.length/2){
                    return n;
                }
            }else{
                occurMap.put(n, 1);
            }
        }
        return nums[0];
    }
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

    public static Map<Integer, Integer> resultMap = new HashMap<>();
    public static int fibonacci_memo(int n){
        if( n == 0 ) {
            // save it first
            resultMap.put(n, 0); 
            return 0;
        }
        else if( n == 1 ) {
            // save it first
            resultMap.put(n, 1); 
            return 1;
        }
        // some other big number
        else{
            // first we gonna check if its first part is in the map already
            int temp1 = 0;
            if(resultMap.containsKey(n-1)){
                temp1 = resultMap.get(n-1);
            }
            // if not then call method
            else{
                temp1 = fibonacci_memo(n-1);
                // cache its output
                resultMap.put(n-1, temp1);
            }
            int temp2 = 0;
            if(resultMap.containsKey(n-2)){
                temp2 = resultMap.get(n-2);
            }
            // if not then call method
            else{
                temp2 = fibonacci_memo(n-2);
                // cache its output
                resultMap.put(n-2, temp2);
            }
            return temp1+temp2;
        }


    }
    public static void main(String[] args) {
        
        System.out.println(Main.fibonacci_memo(5));
        // System.out.println(Main.ReversingDigit(10));
        
        // int[] nums = {2,3,4};
        // System.out.println(Main.TwoSum(nums,6));
        
        // int year = 2024;
        // System.out.println("Is Leap Year: "+(year%4==0 && year%100!= 0 ? "True" : "False"));
        // System.out.println(Main.HighestCommonFactor(16,80));
        // System.out.println(Main.FindCommonFactors(16,80));
        // System.out.println(Main.GreatestCommonDivisor(30,53));
        // int primeNumbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,53, 59, 61};
        
            // System.out.println(4 +" -> " +Main.DecimalToBinary(4));
        // for(int i = 0; i<= 100; i++){
        //     // System.out.println(i +" -> " +Main.isPrimeNumber(i));
        //     System.out.println(i +" -> " +Main.DecimalToBinary(i));
        // }   
    }
}