class Solution {
    public int reverse(int x) {

        int a = x;
        int result = 0;
        
        // Check if number is negative or positive
        boolean isNegative = a<0? true:false;
        if(isNegative)
            a = a*-1;

        while(a>0){
            int lastDigit = a%10;
            // System.out.print("last digit is" + lastDigit);

            // Check if result will overflow when multiplying by 10 and adding the digit
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0; // Overflow case for positive numbers
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0; // Overflow case for negative numbers
            }
            result = result*10 + lastDigit;
            // System.out.print("result" + lastDigit);
            a = a/10;
        }

        // If number is negavtive add - sign to it
        return isNegative==true? result*-1: result;
    }
}
