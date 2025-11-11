
// Finding the Floor and Ceil Value in a Sorted Array

// Floor - Largest Value which is <=x (Target Value)
// Ceil - Smallest Value which is >=x (Target Value) ---> lower bound

class Solution {
    
    // Floor - Largest Value which is <=x
    public int findFloor(int[] arr, int x) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        
        int result = -1; // Default Value
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            // <=
            if(arr[mid]<=x){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return result;
    }

    // Ceil - Smallest Value which is >= x
    // So same as Lower Bound
    public int findCeil(int[] arr, int x) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        
        int result = -1; // Default Value
        
        while(low<=high){
            int mid = low + (high-low)/2;
            // >=
            if(arr[mid]>=x){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return result;
    }
  
}
