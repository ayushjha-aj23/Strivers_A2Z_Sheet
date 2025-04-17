class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        
        int left = 0;
        int right = arr.length-1;
        int result = arr.length;
        
        while(left<=right){
            
            int mid = left + (right-left)/2;
            if(arr[mid]>=target){
                result = mid; // Add the Lower Bound to the result 
                right = mid-1; // Then move the right pointer to mid - 1
            }
            else
                left = mid+1; // Move the left pointer to mid + 1
        }
        
        return result;
    }
}
