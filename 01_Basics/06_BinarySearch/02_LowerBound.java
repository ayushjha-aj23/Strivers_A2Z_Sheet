// GFG
class Solution {
    
    // LowerBound-> smallest index in the sorted array where element is >= to the given number.
    // Or Smallest Index such that arr[index]>=target 
    
    // Move from the extreme right towards left untill you find the smallest index which is
    // >= target index
    
    int lowerBound(int[] arr, int target) {
        // code here
        
        int n = arr.length;
        int result = n;
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid]>=target){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return result;
    }
}
