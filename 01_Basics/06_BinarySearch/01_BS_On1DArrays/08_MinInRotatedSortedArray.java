
// LC-153

class Solution {

    // Linear Search 

    // Binary Search 
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]<min)
                min = nums[mid];

            // Check if left half is sorted or not
            if(nums[low]<=nums[mid]){

                // check if low is smaller then min or not and if smaller then update min
                if(nums[low]<min)
                    min = nums[low];

                low = mid+1;
            }else{ // right half is sorted
                // Check if mid+1 is smaller then min or not and if smaller then update min
                if(nums[mid+1]<min)
                    min = nums[mid+1];
                
                high = mid-1;
            }
        }

        return min;
    }
}
