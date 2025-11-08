
// Approach-1: Naive Approach - Find the range i.e. largest-smallet for every subarray
// TC - O(N2) and SC - O(1)
/*
class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        long range = 0;

        for(int i=0; i<n; i++){
            int largest = nums[i];
            int smallest = nums[i];

            for(int j=i; j<n; j++){ // We can take j=i+1 as single element subarray is giving 0 and of no use. Starting from i+1 and not i because i=0;j=0 -> arr[0] 
            // largest and smallest both are 1 if [1,2,3] and then its result is 0
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                range = range + (largest-smallest);
            }
        }
        return range;
    }
}
*/

// Approach-2: Optimised Approach -> Subarray Maximums-Subarray Minimums
class Solution {
    public long subArrayRanges(int[] nums) {
        
    }
}
