// LC-9 -> Pallindrome Number
class Solution {
    public boolean isPalindrome(int x) {
        
        // Case 1: If x is -ve because -151 is not equal to 151-
        if(x<0)
            return false;

        // Case 2: If x is +ve
        int temp = x;
        int rev = 0;

        while(temp!=0){
            int lastDigit = temp%10;
            rev = (rev*10)+lastDigit;
            temp = temp/10;
        }

        if(rev==x)
            return true;
        else
            return false;
    }
}
