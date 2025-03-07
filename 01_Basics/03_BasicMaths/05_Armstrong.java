// User function Template for Java
class Solution {
    
    static boolean armstrongNumber(int n) {
        // code here
        
        int temp = n;
        int armCheck = 0;
        
        while(temp!=0){
            int lastDigit = temp%10;
            armCheck += lastDigit*lastDigit*lastDigit;
            temp = temp/10;
        }
        
        if(armCheck==n)
            return true;
        else
            return false;
    }
}
