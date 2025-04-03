class Solution {

    // Sort and then Sliding Window to find the maximum window i.e. frequency
    
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums); // TC-O(N log N)

        int l =0;
        int r = 0; // Left and Right Pointer
        long result = 0; // Max Frequency Possible
        long total = 0; // Current Window Total

        while(r<nums.length){

            total += nums[r]; // Add the right index value to the total

    // CONDITION
    // "If Rigth Value*Length of Window - total of Window > K times if incremented"
    // Condition to check if we can make all elements in the window equal to nums[r] with at most k operations
    // nums[r] * (r - l + 1) represents the cost if all the elements in the current window were to become equal to nums[r]
    // Condition to check if we can make all elements in the window equal to nums[r] with at most k operations
    // The difference between (nums[r] * window length) and current window sum must be <= k
    // All Elements in the window of length is greater after making k operations
    // Just Decrease the size of window by moving the left forward

            while( (long)nums[r]*(r-l+1) > total + k){ // r-l+1 is the window length
                total -= nums[l]; // Remove the value of left from total
                l++; // Move left forward
            }

            result = Math.max(result, r-l+1); 
            // Result will be max of result and size of window i.e. Window Length
            r++;
        }

        return (int) result;
    }
    
    
    
    /*
    public int maxFrequency(int[] nums, int k) {

        int l=0;
        int r=0;
        long result = 0;
        
        Arrays.sort(nums);
        long total = nums[0];

        while(r<nums.length){
            if((long)(r-l+1)*nums[r]<= k + total){
                result = Math.max(result, r-l+1); 
            // Result will be max of result and size of window i.e. Window Length
                r++; // Move the right pointer
            
                if(r<nums.length)
                    total += nums[r];
            }else{
                total -= nums[l];
                l++;
            }
        }
        return (int) result;
    }
  */
    
}
