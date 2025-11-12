// LC-34 N GFG

class Solution {

    // Approach 1: Linear Search 
    // TC - O(N)
    /*
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        int first = -1;
        int last = -1;

        for(int i=0; i<n; i++){
            if(nums[i] == target && first==-1){
                first = i;
                last = i;
            }else if(nums[i]== target && first!=-1){
                last = i;
            }
        }

        return new int[] {first, last};
    }
    */


    // Approach 2: Binary Search 
    // Use of Lower Bound N Upper Bound
    // E.g. [2, 4, 6, 8, 8, 8, 11, 13]
    // Lower Bound is >= x
    // Upper Bound is > x
    // For E.g. x = 8 then LB=index 3, UB=index 6 
    // So LB is giving first occurence and UB-1 is giving last occurence 

    // Edge Case 1: x not present in array because it is bigger element -> LB==Size of array then -1,-1
    // Edge Case 2: x not present in array because it is missing between the elements -> arr[LB]!=x then -1, -1

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target)-1; // As last occurence is Upper Bound-1

        // Edge Case: Not Present
        // if bigger element OR if missing between the 2 elements
        // LB == Size of array means default value OR nums[LB]!= target means in this LB will give next greater
        if(first==n || nums[first]!=target)
            return new int[] {-1, -1};
        else
            return new int[] {first, last};
    }

    // Lower Bound -> nums[i]>=target
    private int lowerBound(int[] nums, int target){
        int n = nums.length;
        int low = 0; 
        int high = n-1;
        int result = n; // Default value, start from the last and every time decrease the bound

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]>=target){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return result;
    }

    // Upper Bound -> nums[i]>target
    private int upperBound(int[] nums, int target){
        int n = nums.length;
        int low = 0; 
        int high = n-1;
        int result = n; // Default value, start from the last and every time decrease the bound

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]>target){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return result;
    }    
}
