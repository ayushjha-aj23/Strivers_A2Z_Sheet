class Solution {

    // Linear Search 
    /*
    public int peakElement(int[] arr) {
        // code here
        
        // If length is 1
        if(arr.length==1)
            return 0;
        
        // For 1st Element
        if(arr[0]>arr[1])
            return 0;
    
        // For Last Element
        if(arr[arr.length-1]> arr[arr.length-2])
            return arr.length-1;
        
        
        // 1st Element is Peak - If it is greater then 2nd element
        // Last Element is Peak - If it is greater then 2nd last element
        // Middle Element is Peak - If greater then previous and next element
        for(int i=1; i<arr.length-1; i++){
             if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return i;
        }
        
        return -1;
    }
    */
    
    
    // Binary Search - It does not require sorting 
    // We don’t need to sort the array because we’re not searching 
    // for a specific value but looking for a peak element, 
    // and the problem guarantees that at least one peak exists.
    public int peakElement(int[] arr) {
        // code here
        
        int n = arr.length;

        // If length is 1, then it is peak element
        if(arr.length==1)
            return 0;
        
        // Check for 1st Element
        if(arr[0]>arr[1])
            return 0;
    
        // Check for Last Element
        if(arr[arr.length-1]> arr[arr.length-2])
            return arr.length-1;

        // Search Space for binary Search
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Find the average 

            // If the element at mid is a  
            // peak element return mid
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            return mid;

            // If next neighbor is greater, then peak
            // element will exist in the right subarray
            if (arr[mid] < arr[mid + 1])
                low = mid + 1;

            // Otherwise, it will exist in left subarray
            else
                high = mid - 1;
        }

        return 0;
    }
}
