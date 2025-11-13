
// LC-540

class Solution {

    // Approach 1: Linear 
    /*
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n==1)
            return nums[0];

        for(int i=0; i<n; i++){
            // If 1st element is single
            if(i==0){
                if(nums[i]!=nums[i+1])
                    return nums[i];
            }else if(i==n-1){ // If last element is single
                if(nums[i]!=nums[i-1])
                    return nums[i];
            }else{ // To check for all the middle elements
                if(nums[i-1]==nums[i]||nums[i+1]==nums[i])
                    continue;
                else
                    return nums[i];
            }
        }

        return -1;
    }
    */


    // Approach 2: Binary Search 


    // even, odd -> Before single element (left half)
    // odd, even -> After single element (right half)
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        // If only 1 element
        if(n==1)
            return nums[0];
        // Checking for 1st element with 2nd element
        if(nums[0]!=nums[1])
            return nums[0];
        // Checking fot last element with second last element
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];

        int low = 1;
        int high = n-2;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(nums[mid-1]!=nums[mid]&&nums[mid+1]!=nums[mid])
                return nums[mid];
            
            // if mid is odd
            // odd (mid % 2 == 1) then -> nums[mid] == nums[mid-1]
            if(mid%2!=0){
                if((nums[mid]==nums[mid-1])) // We are at left half, so eleminate it and check in right half
                    low = mid+1;
                else 
                    high = mid-1;
            }else{ // mid is even // even (mid % 2 == 0) then -> nums[mid] == nums[mid+1]
                if((nums[mid]==nums[mid+1]))
                    low = mid+1;
                else 
                    high = mid-1;
            }
        }
        return -1;

    }

    // Approach - 3 Using Bit Manipulation
    // XOR 
    //a^a=0 so only the number which is single will remain
    /*
    public int singleNonDuplicate(int[] nums) {
        int result = 0;

        for(int i: nums){
            result = result^i;
        }

        return result;
    }
    */
}

