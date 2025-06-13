// GFG - Reverse Digit 
// User function Template for Java

class Solution {
    public int reverseDigits(int n) {
        // Code here
        
        int temp = n;
        int digitFromLast = 0;
        int reverseDigit = 0;
        
        while(temp!=0){
            digitFromLast = temp%10;
            reverseDigit = reverseDigit*10 + digitFromLast;   
            temp = temp/10;
        }
        return reverseDigit;
        
    }
}

// LC-7 -> Reverse Integer
class Solution {
    public int reverse(int x) {

        int a = x; // Make a copy of x
        int result = 0; 
        
        // Check if number is negative or positive
        boolean isNegative = x<0? true:false;

        // If inputted number is -ve make it +ve just for computation
        if(isNegative)
            a = a*-1;

        while(a>0){
            int lastDigit = a%10; // Extracr the last digit

            // -2,147,483,648
            // Check if result will overflow or not (1)when multiplying by 10 (2) If result*10=MAX_VALUE and lastDigit is > 7
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0; // Overflow case for positive numbers
            }

            // 2,147,483,647
            // Check if result will underflow or not (1)when multiplying by 10 (2) If result*10=MIN_VALUE and lastDigit<-8 like -9
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0; // Overflow case for negative numbers
            }

            // If not both conditions then only multiply by 10 and then add lastDigit
            result = result*10 + lastDigit;
            a = a/10; // Remove lastDigit
        }

        // If number was negavtive add - sign to it
        // if(isNegative){result *= -1;}
        // OR
        return isNegative==true? result*-1: result;
    }
}
