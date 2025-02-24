// Binary Search Or Sorted Array Search 
// We can do this using - Iterative or Recursive Way

class Solution {
  
    // Iterative Way
    // TC-O(log N) SC-O(1)
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            int mid = (low+high)/2; 
            
            if(arr[mid]==k)
                return true;
            
            if(arr[mid]<k)
                low = mid+1;
            
            if(arr[mid]>k)
                high = mid-1;
        }
        return false;
    }
    
    // Recursive Way 
    // TC-O(log N) SC-O(log N)
    /*
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        return binarySearch(arr, k, 0, arr.length-1);
    }
    
    static boolean binarySearch(int arr[], int k, int low, int high){
        if(low>high)
            return false;
        
        int mid = (low+high)/2;
        
        if(arr[mid]==k)
            return true;
        
        if(arr[mid]<k)
            return binarySearch(arr, k, mid+1, high);
        else
            return binarySearch(arr, k, low, mid-1);
    }
    */
}
