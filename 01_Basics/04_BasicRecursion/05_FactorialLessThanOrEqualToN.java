// User function Template for Java
class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        return findFactorialNumbers(n, 1, 1);
    }
    
    // Method to find the Factorial Number
    // Function to find factorial numbers <= n using recursion
    public static ArrayList<Long> findFactorialNumbers(long n, long currentFactorial, int i) {
        ArrayList<Long> result = new ArrayList<>();
        
        // Base case: if current factorial exceeds n, return the result list
        if (currentFactorial > n)
            return result;

        // Add the current factorial to the result list
        result.add(currentFactorial);
        
        // Recursively find the next factorial
        ArrayList<Long> nextFactorials = findFactorialNumbers(n, currentFactorial * (i + 1), i + 1);
        
        // Append the next factorials to the result list
        result.addAll(nextFactorials);
        
        return result;
    }
}
