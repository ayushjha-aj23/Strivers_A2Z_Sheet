

// GFG 

class Solution {
    
    
    // Naive Approach - Linear Scan 
    // TC -O(max-min)*O(n)
    // SC-O(1)
    
    
    /*
    // start = 1 and end = max-min (max distance possible)
    public int aggressiveCows(int[] stalls, int cows) {
        // code here
        
        // Sort the array
        Arrays.sort(stalls);
        
        int n = stalls.length;
        int min = stalls[0];
        int max = stalls[n-1];
        for(int i=1; i<=max-min; i++){
            
            if(canPlace(stalls, i, cows)){ // stalls, distance to be maintained, cows to maintain
                continue;
            }else{
                return i-1; // return last possible value
            }
        }
        
        return max-min; 
        
    }
    
    
    private boolean canPlace(int[] stalls, int dis, int cows){
        
        // 1st cow always at 1st stall
        int countCows = 1;
        int lastPlacedPos = stalls[0]; // as 1st is placed at 0th position
        
        
        int n = stalls.length;
        for(int i=1; i<n; i++){
            
            if(stalls[i]-lastPlacedPos>=dis){ // distance should be greater then or equal to min distance dis between 2 cows
                countCows++; // increase count
                lastPlacedPos = stalls[i]; // update last position
            }
            
            // as soon as countCows is equal to cows return true
            if(countCows==cows)
                return true;
        }
        
        return false;
    }
    
    */
    
    
    // Optimised Approach - Using Binary Search
    
    // low = 1
    // high = max-min
    public int aggressiveCows(int[] stalls, int cows) {
        // code here
        
        // Sort the Array
        Arrays.sort(stalls);
        
        int n = stalls.length;
        int min = stalls[0];
        int max = stalls[n-1];
        int low = 1;
        int high = max-min;
        int result = 0;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(canPlace(stalls, mid, cows)){
                result = mid; // update result as it can be my result
                low = mid+1; // as we need max
            }else{
                high = mid-1;
            }
        }
        
        return result;
    }
    
    private boolean canPlace(int[] stalls, int dis, int cows){
        
        // 1st cow always at 1st stall
        int countCows = 1;
        int lastPlacedPos = stalls[0]; // as 1st is placed at 0th position
        
        
        int n = stalls.length;
        for(int i=1; i<n; i++){
            
            if(stalls[i]-lastPlacedPos>=dis){ // distance should be greater then or equal to min distance dis between 2 cows
                countCows++; // increase count
                lastPlacedPos = stalls[i]; // update last position
            }
            
            // as soon as countCows is equal to cows return true
            if(countCows==cows)
                return true;
        }
        
        return false;
    }
    
    
}
