// GFG

// User function Template for Java
class Solution {
    static int evenlyDivides(int n) {
        // code here
        
        int temp = n;
        int count = 0;
        
        
        while(temp!=0){
            int lastDigit = temp%10;
            // First check lastDigit should not be equal to 0
            // Also check if n is completely divisible by lastDigit or not 
            if(lastDigit!=0 && n%lastDigit==0)
                count++;
            temp = temp/10;
        }
        return count;
    }
}
