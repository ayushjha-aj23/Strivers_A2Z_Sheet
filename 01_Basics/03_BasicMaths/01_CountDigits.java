// GFG- Count Digits
class Solution {
    public int countDigits(int n) {
        // code here
        int temp = n;
        int totalDigits = 0;
        
        while(temp!=0){
            totalDigits++;
            temp = temp/10;
        }
        return totalDigits;

        // Or 
        // int totalDigits = (int) Math.log10(n) + 1;
        // System.out.println(totalDigits);
    }
}

// GFG - Count Digits - 2
// User function Template for Java
class Solution {
    static int evenlyDivides(int n) {
        // code here
        int temp = n; // make a copy of n
        int count = 0;
        
        while(temp!=0){
            int lastDigit = temp%10; // Get the last digit
            
            // First check lastDigit should not be equal to 0
            // Also then check if n is completely divisible by lastDigit or not 
            // If we 1st check n%lastDigit==0 where lastDigit = 0 then we will get ArithmeticException
            
            if(lastDigit!=0 && n%lastDigit==0)
                count++; // Increment Count
            temp = temp/10; // Remove the last Digit
        }
        return count; 
    }
}
