// User function Template for Java
class Solution {
    
    // Naive Approach - Nested Loops
    /*
    public static int sumOfDivisors(int n) {
        // code here
        
        int result = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(i%j==0)
                    result += j;
            }
        }
        
        return result;
    }
    */
    
    // Better Approach - divisors of a number come in pairs
    // For example, if (d) is a divisor of (i), then (i/d) is also a divisor of (i). 
    // You don't need to check all numbers up to (i)
    // Instead, you only need to check numbers up to sqrt(i) to find all divisors.
    /*
    public static int sumOfDivisors(int n) {
        // code here
        
        // In the inner loop we are using - j*j<=i
        // So, if j!=(i/j), then add it to result 
        // It add those, where if -> j=36
        
        
        int result = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){ // Find divisors of i by checking up to sqrt(i)
                if(i%j==0){
                    result += j;
                
                    // Add the paired divisor i/j, but avoid adding the square root twice
                    // Only when j==(i/j), OR we can say If j is not the square root of i, add i / j as well
                    if (j != i / j) { //Like if i=3, j=1---> then j=1 and (i/j)=3 then add 3
                        result += i / j;
                    }
                }
            }
        }
        return result;
    }
    */
    
    // Optimised Approach - For a given number n, every number from 1 to n 
    // contributes its presence up to the highest multiple less than n
    // e.g. n=4 then 
    // 1->4time, 2->2time, 3->1time, 4->1time
    // Highest Multiple -> (n/i) and for i so multiple by (i)
    public static int sumOfDivisors(int n) {
        // code here
        int sum = 0;
        
        for(int i=1; i<=n; i++)
            sum += (n/i)*i;
        
        return sum;
    }
    
}
