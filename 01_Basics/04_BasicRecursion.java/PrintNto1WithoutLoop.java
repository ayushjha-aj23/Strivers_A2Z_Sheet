class Solution {

    void printNos(int N) {
        // code here 
        printNto1(N);
    }
    
    void printNto1(int N){
        // Base Condition
        if(N==0)
            return;
        // Print Statement
        System.out.print(N + " ");
        // Condition Check
        printNto1(N-1);
    }
}
