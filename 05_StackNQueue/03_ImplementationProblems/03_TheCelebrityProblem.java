// LC-277, GFG, Striver


class Solution {
    
    // Naive Approach - 
    // TC - O(N*N) + O(N) and SC - O(2N)
    /*
    public int celebrity(int mat[][]) {
        // code here
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[] knowMe = new int[m];
        int[] iKnow = new int[m];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // If value is 1 and is not diagonal element
                if(mat[i][j]==1 && i!=j){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        
        
        // Check 
        // knowMe mae n-1 value and iKnow mae same per 0
        for(int i=0; i<n; i++){
            
            if(knowMe[i]==n-1 && iKnow[i]==0)
                return i;
        }
        
        return -1;
    }
    */
    
    // Optimised Approach 
    // TC - O(2N) and SC- O(1)
    // Min Celebs 0 and Max Celebs 1
    public int celebrity(int mat[][]){
        
        int n = mat.length;
        
        // Two Pointer
        int top = 0;
        int bottom = n-1;
        
        while(top<bottom){
            
            if(mat[top][bottom]==1)
                top++; // top knows bottom → top not celebrity
            else
                bottom--; //top doesn't know bottom → bottom not celebrity
        }
        
        // Store the candidate
        int candidate = top;
        
        // Verify Candidate
        for(int i=0; i<n; i++){
            
            // Skip self check
            if(i==candidate)
                continue;
            
            if(mat[candidate][i] == 1 || mat[i][candidate] == 0)
                return -1;
        }
        
        return candidate;
    }
}
