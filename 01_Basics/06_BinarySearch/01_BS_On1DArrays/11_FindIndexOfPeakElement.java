
// LC-162, 852

class Solution {
    public int findPeakElement(int[] arr) {

        int n = arr.length;
        int low = 1;
        int high = n-2;

        // if only 1 element always peak as it is between -infinities
        // E.g. -infinity[2]-infinity
        if(n==1)
            return 0;
        
        // if arr[0] i.e. 1st element is greater then 2nd
        // E.g. -infinity[5,4,3,1,0]
        if(arr[0]>arr[1])
            return 0;
        
        // if arr[n-1] i.e. last element is grater then 2nd last
         // E.g. [1,3,4,5]-infinity
        if(arr[n-1]>arr[n-2])
            return n-1;


        // Check for middle elements except 1st and last
        while(low<=high){
            int mid = low + (high-low)/2;

            // Checking mid with its adjacents --> mid-1<mid>mid+1
            if(arr[mid-1]<arr[mid]&&arr[mid]>arr[mid+1])
                return mid;

            if(arr[mid]<arr[mid-1])
                high = mid-1;
            else
                low = mid+1;
        }

        return -1; 
    }
}
