
// LC - 81

// Same as rotated sorted array only 1 condition check is added 
 // E.g. [3, 1, 2, 3, 3, 3]
 // if(nums[low]==nums[mid] && nums[mid]==nums[high] then low++; and high--;

class Solution {

    // Linear

    // Binary Search 
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            // If mid is the target
            if(nums[mid]==target)
                return true;

            // If value at low, mid and high all are equal
            // E.g. [3, 1, 2, 3, 3, 3]
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if(nums[low]<=nums[mid]){
                if(target>=nums[low]&&target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{ // Right half is sorted
                if(target>nums[mid]&&target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return false;
    }
}
