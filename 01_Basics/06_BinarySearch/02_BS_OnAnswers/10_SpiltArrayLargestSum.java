
// LC-410

class Solution {

    // Split the array into K subarrays such that the max subarray sum is minimum

    // min(largest sum of any subarray)
    // E.g. -> 7 2 5  10 8  
    //         7 9 14 24 32
    // Possiblities and their largest sum
    // (7) (2 5 10 8) -> 25
    // (7 2) (5 10 8) -> 23
    // (7 2 5) (10 8) -> 18 -> Minimum
    // (7 2 5 10) (8) -> 24


    // low = max element
    // high = sum of all element - min element
    
    // Linear Search
    // O((sum−max) * n) - Gives TLE
    /*
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // For finding max and sum
        for(int i: nums){
            max = Math.max(max, i);
            sum += i; // Find sum of all 
        }

        if(n<k) return -1;

        for(int i=max; i<=sum; i++){

            int spilts = findSubarraySum(nums, i);

            if(spilts<=k)
                return i;
        }

        return -1;
    }


    private int findSubarraySum(int[] nums, int a){

        int n = nums.length;
        int count = 0;
        int c = 1;
        for(int i=0; i<n; i++){
            if(count+nums[i]<=a){
                count += nums[i];
            }else{
                c++;
                count = nums[i];
            }
        }

        return c;
    }
    */

    // Optimised Approach - Using Binary Search 
    // TC - O(n log(sum))
    // low = max element and high = sum of all elements
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // For finding max and sum
        for(int i: nums){
            max = Math.max(max, i);
            sum += i; // Find sum of all 
        }

        if(n<k) return -1;

        int low = max;
        int high = sum;
        int result = 0;

        while(low<=high){
            int mid = low+(high-low)/2;

            int spilts = findSubarraySum(nums, mid);

            if(spilts<=k){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return result;
    }

    private int findSubarraySum(int[] nums, int limit){

        int n = nums.length;
        int currSum = 0;
        int used = 1;
        for(int i=0; i<n; i++){
            if(currSum+nums[i]<=limit){
                currSum += nums[i];
            }else{
                used++;
                currSum = nums[i];
            }
        }
        return used;
    }
}
