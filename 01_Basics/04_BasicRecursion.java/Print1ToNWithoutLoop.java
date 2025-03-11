// User function Template for Java
class Solution {
    public void printNos(int n) {
        // Your code here
        printN(n);
    }
    
    public void printN(int N){
        
        // Base Condition
        if(N==0)
            return;
        
        // Call Itself
        printN(N-1);
        
        // Print Statement
        System.out.print(N + " ");
    }
}
