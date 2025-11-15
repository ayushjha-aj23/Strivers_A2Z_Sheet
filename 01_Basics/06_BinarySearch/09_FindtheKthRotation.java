
// GFG
// Find out how many times has an array been rotated


class Solution {
    
    
    // To find out the rotation
    // E.g. arr=[5,1,2,3,4]
    // Find the min element and the index of min element-0 should be the number of times it is rotated
    // As if it is not rotated then the index of min element should be 0 
    public int findKRotation(int arr[]) {
        // Code here
        
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        int indexOfMin = 0;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(arr[mid]<min){
                min = arr[mid];
                indexOfMin = mid;
            }
               
            // Check if left half is sorted 
            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min = arr[low];
                    indexOfMin = low;
                }
                
                low = mid+1;
            }else{ // Else right half is sorted
                if(arr[mid+1]<min){
                    min = arr[mid+1];
                    indexOfMin = mid+1;
                }
                
                high = mid-1;
            }
        }
        
        return indexOfMin;
    }
}
