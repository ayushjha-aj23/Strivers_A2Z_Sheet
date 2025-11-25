
// LC-1283

class Solution {


    // Smallest Divisor - 1
    // Greatest Divisor - max of nums
    // Range -> [1-------max(nums)]
    // So Binary Search on Answers is Possible
    
    
    // Naive - Start with the smallest divisor i.e. 1 and move upwards - Linear Scan - TLE
    /*
    public int smallestDivisor(int[] nums, int threshold) {
        
        // int divisor = 1;
        int n = nums.length;
        int max = findMax(nums);
        int total = 0;

        // Check for every possible answer
        for(int d=1; d<=max; d++){
            // Scan for finding the ceil after divison and adding it to the total
            for(int i=0; i<n; i++)
                total += (int) Math.ceil( (double)nums[i]/d);
            
            // System.out.println(d+" "+total);

            if(total<=threshold)
                return d;
            else
                total = 0;
        }

        return -1;
        
    }

    private int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max, i);
        }
        // System.out.println(max);
        return max;
    }
    */

    // Optimised - Binary Search 
    // low = 1 and high = max(nums)
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);
        int possible = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            int n = nums.length;
            int total = 0;

            for(int i=0; i<n; i++)
                total += (int) Math.ceil( (double)nums[i]/mid);
                // (nums[i] + mid - 1) / mid


                // if total is less -> update possible and check if smaller divisor is possible or not
                if(total<=threshold){
                    possible = mid;
                    high = mid - 1;
                }
                else{
                    low = mid+1;
                }
        }

        return possible;
    }

    private int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i: nums)
            max = Math.max(max, i);
        return max;
    }
}
