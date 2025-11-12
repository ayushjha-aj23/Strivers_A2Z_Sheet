
// LC-33

class Solution {

    // 1: Linear Search

    // 2: Binary Search  
    // Binary Search is eleminating 1 half either left or right half
    
    // Find mid 
    // Every time either of the 2 halves will be sorted 
    // Identify the sorted half and check with the target
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            // if target is found at mid
            if(nums[mid]==target)
                return mid;

            // Left half is sorted
            if(nums[low]<=nums[mid]){
                // target>=low && target<mid
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else { // Right half is sorted
                // target>mid && target<=high
                if(target>nums[mid] && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
