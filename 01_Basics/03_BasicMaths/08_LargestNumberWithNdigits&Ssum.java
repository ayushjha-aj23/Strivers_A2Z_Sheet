// GFG - Largest number possible

// User function Template for Java

class Solution {
    static String findLargest(int n, int s) {
        // code here
        
        // Step1: Take Array becuase we have to fill int from left->right
        int[] result = new int[n];
        
        // Step2: If (sum=0 and digit>1) ya phir (s>9*no. of digits)
        // Return -1 as it is not possible
        if( (s==0 && n>1) || (s>9*n)) 
                return "-1";
        
        // Step 3: Move from left->right
        for(int i=0; i<n; i++){
            
            // if sum<=9 fill 1st left with sum and rest all digits as zero
            if(s<=9){
                result[i] = s;
                break;
            }else{ // if sum>9 fill 9 in left and reduce the sum everytime
                result[i] = 9;
                s -= 9;
            }
        }
        
        // Step 4: Convert int[] to String using StringBuilder and return it
        StringBuilder sb = new StringBuilder();
        for(int i: result)
            sb.append(i);
        
        return sb.toString();
    }
}
