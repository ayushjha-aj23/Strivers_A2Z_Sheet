// Before this Problem let us first find out all the Divisors a Number (N)
// Approach-1: For Loop - TC-O(N)
/*
public static void print_divisors(int N) {
        // code here
        
        for(int i=1; i<=N; i++){
            if(N%i==0){
                System.out.print(i + " ");
            }
        }
    }
*/

// Approach-2 
/*
// Approach-2 -> N and N/i
    // 1*36
    // 2*18
    // 3*12
    // 4*9
    // 6*6 
    // .............
    // 9*4
    // 12*3
    // 18*2
    // 36*1
    
    // Output will be different -> 1 36 2 18 3 12 4 9 6
    // So just to make sure it is in sorted order then -> Store and Sort
    // But motive here is -> We can find the factors TC - sqrt(N)
    
    public static void print_divisors(int N) {
        // code here
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=Math.sqrt(N); i++){
            if(N%i==0){
                list.add(i);
                
                if((N/i)!=i) // Just to make sure i is not printed twice (here 6)
                    list.add(N/i);
            }
        }
        
        Collections.sort(list);
        
        for(int i: list)
            System.out.print(i + " ");
    }
*/






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
