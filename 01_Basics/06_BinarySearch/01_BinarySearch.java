// Binary Search in an Array

class Solution {

    // We have 2 approaches for Binary Search - Iterative Way and Recursive Way

    // Approach 1: BS Iterative
    // TC - O(log N)
    /* 
    public int search(int[] nums, int target) {

        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(target == nums[mid])
                return mid;

            if(target<nums[mid])
                right = mid-1;
            else
                left = mid+1; 
        }

        return -1;
        
    }
    */


    // Approach 2: BS Recursive
    // TC - O(log N)
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        return searchFun(nums, low, high, target);
    }

    private int searchFun(int[] nums, int low, int high, int target){
        // mid
        int mid = low + (high-low)/2;

        // Base Case
        if(low>high)
            return -1;
        else if(nums[mid]==target)
            return mid;
        else if(target>nums[mid])
            return searchFun(nums, mid+1, high, target);
        else
            return searchFun(nums, low, mid-1, target);
    }
}
