class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        
        int left = 0;
        int right = arr.length-1;
        int result = arr.length;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(arr[mid]<=target){
                left = mid+1; 
            }else{
                result = mid; // Add the Upper Bound to the result 
                right = mid-1;
            }
        }
        
        return result;
    }
}
