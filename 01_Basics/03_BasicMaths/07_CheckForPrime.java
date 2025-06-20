// Prime Number -> A number is called prime if it has exactly 2 divisors -> 1 and Number itself.

class Solution {
    
    // Naive Approach - TC-O(N) and SC-O()
    /*
    static boolean isPrime(int n) {
        // code here
        
        for(int i=2; i<n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    */

    // Better Approach 
    // TC - O(sqrt(N))
    static boolean isPrime(int n) {
        // code here
        int count = 0;
        
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                count++;
                if((n/i)!=i)
                    count++;
            }
        }
        
        if(count==2)
            return true;
        else
            return false;
    }
    

    // Optimised Approach - 
    static boolean isPrime(int n) {
        // code here
        if(n<=1)
            return false;
        if(n==2) // Only Prime number which is even 
            return true;
        if(n%2==0) // All other even numbers are prime
            return false;
        
        
        // Start from 3 and every time skip even number so i+=2
        // And till i*i<=n, equal case is to check for perfect square 
        for(int i=3; i*i<=n; i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
