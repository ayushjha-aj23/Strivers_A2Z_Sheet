
// GFG
class Solution {
    
    // Linear Search
    // TC - O(N)
    /*
    int countFreq(int[] arr, int target) {
        // code here
        
        int n = arr.length;
        int count =0;
        
        for(int i=0; i<n; i++){
            if(arr[i]==target)
                count++;
        }
        
        return count;
    }
    */
    
    // Binary Search
    int countFreq(int[] arr, int target) {
        // code here
        
        // arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2 -> Output = 4
        // firstOccurence(LB) = 2 n lastOccurence(UB-1) = 5 
        // totalOccurences = (lastOccurence-firstOccurence)+1;
        
        // 1->total = lastOccurence-firstOccurence+1 
        // 2->total = UpperBound-LowerBound 
        
        int totalOccurences = upperBound(arr, target)-lowerBound(arr, target);
        return totalOccurences;
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
