// GFG - LCM And GCD
// User function Template for Java

class Solution {
    
    // Naive Approach - 
    // GCD(HCF) using Euclidean Algorithm(Euclid Method)
    // GCD(a,b) -> GCD(a-b, b) where a>b eveytime gets smaller
    // E.g. GCD(20,15) -> GCD(5, 15) -> GCD(15,5) -> GCD(10,5) -> GCD(5, 0) -> As 1 of them is 0 so the other one is GCD 
    // So, 5 is GCD of 20, 15
    // Its better to modify formula as to reduce the number of steps -> GCD(a,b) -> GCD(a%b, b) where a>b 
    
    // LCM - a. find max 
    //       b. then find smallest value that can divide both the nums means modulus is 0
    /*
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        
        int result[] = new int[2];
        
        // For GCD
        int aGCD = a;
        int bGCD = b;
        
        while(bGCD!=0){
            int temp = bGCD; // Save the value of b in temp
            bGCD = aGCD%bGCD; // Update b as the remainder of a and b - a%b
            aGCD = temp; // Update the value of a by temp(b)
        }
        
        // In the last iteration a will store the GCD and b will store 0
        result[1] = aGCD;
        
        // For LCM
        int aLCM = a;
        int bLCM = b;
        int LCM = Math.max(aLCM, bLCM);
        
        while(true){
            if(LCM%aLCM==0 && LCM%bLCM==0) // 2-At any point if a,b both divides LCM then break and return
                break;
            
            LCM++; // 1- Every time increment with 1 and check 
        }
        result[0] = LCM;
        
        return result;
    }
    */
    
    // Optimised Approach
    // LCM(a,b)*HCF(a,b) = a*b;
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        
        int[] result = new int[2];
        
        // For GCD
        int aGCD = a;
        int bGCD = b;
        
        while(bGCD!=0){
            int temp = bGCD; // Save the value of b in temp
            bGCD = aGCD%bGCD; // Update b as the remainder of a and b - a%b
            aGCD = temp; // Update the value of a by temp(b)
        }
        
        // In the last iteration a will store the GCD and b will store 0
        result[1] = aGCD;
        
        // For LCM
        int LCM = (a*b)/aGCD;
        result[0] = LCM;
    
        return result;
    }
}

// Similar Question
// LC - 1979. Find Greatest Common Divisor of Array

/*
class Solution {
    public int findGCD(int[] nums) {

       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;

       for(int i: nums){
        if(i<min)
            min = i;
        
        if(i>max)
            max = i;
       }
        // System.out.println(min + " " + max);
        int result = getGCD(min, max);
       return result;
    }

    public int getGCD(int a, int b){
        int a_GCD = a;
        int b_GCD = b;
        int temp;

        while(b_GCD!=0){
            temp = b_GCD;
            b_GCD = a_GCD%b_GCD;
            a_GCD = temp;
        }

        return a_GCD;
    }
}
*/
