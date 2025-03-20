// User function Template for Java

class Solution {
    
    // Naive Approach - 
    // GCD(HCF) using Euclidean Algorithm(Euclid Method)
    // LCM - find max and then smallest value then can divide both the nums 
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
