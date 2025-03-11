// User function Template for Java
class Solution {
    public void printNos(int n) {
        // Your code here
        
        printN(n);
    }
    
    public void printN(int N){
        
        // Base Condition
        if(N>0){
            printN(N-1);
            System.out.print(N + " ");
        }
        return;
    }
}
