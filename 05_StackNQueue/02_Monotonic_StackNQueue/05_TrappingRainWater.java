
class Solution {

    // Method 1: Naive Approach 
    // TC - O(N2) and SC - O(1)
    // Need Taller Building on the Left and Right then only the water will be stored in the middle
    // Only the water will be stored in between upto a height which is min of(leftMax n rightMax)
    // It will store above the top of some height so some height will be removed - height[i]
    // So - Math.min(leftMax, rightMax)-height[i])

    /*
    public int trap(int[] height) {
        
        int n = height.length;
        int totalWater = 0;

        for(int i=0;i<n;i++){
            
            // LeftMax - Find the maximum element on its left
            int leftMax = 0;
            for(int j=0;j<=i;j++) 
                leftMax = Math.max(leftMax, height[j]);
            
            // RightMax - Find the maximum element on its right
            int rightMax = 0;
            for(int j=i;j<n;j++)
                rightMax = Math.max(rightMax, height[j]);
            
            // Update the totalWater
            totalWater += Math.max(0, Math.min(leftMax, rightMax)-height[i]);
            // We have taken max of 0 or (Math.min(leftMax, rightMax)-height[i])
            // Because in 1 edge case - if current bar is taller then min of leftMax and rightMax 
            // Then no water will be stored and it will give negative answer
            // So, considering max of 0 or (Math.min(leftMax, rightMax)-height[i]) is imp.
        }
        return totalWater;
    }
    */

    

    // Method 2: Alternative Approach - For Finding LeftMax n RightMax using PrefixMax n SuffixMax
    // TC - O(3N) and SC - O(2N)
    // E.g. a=[2, 1, 0, 5, 3]-Traverse from the beginning n compare each time with a[i] (1 to n-1)
    // PrefixMax = [2, 2, 2, 5, 5]

    // E.g. b=[5, 1, 11, 2, 10]-Traverse from the last n compare each time with a[i] (n-2 to 0)
    // SuffixMax = [11, 11, 11, 10, 10]

    // Compute the PrefixMax and SuffixMax of the given array 
    // Traverse from 0 to n-1
    //      leftMax = PrefixMax[i] and rightMax = SuffixMax[i]
    //      if(arr[i]<leftMax && arr[i]<rightMax)
    //          totalWater += Math.min(leftMax, rightMax)-height[i];
    // return totalWater;



    // Method 3: Optimised Approach - Using Two Pointer 
    // TC - O(N) and SC - O(1)
    // We only need the smaller one between the two (leftMax and rightMax) 
    // At each step:
    // 1. If the left height is less than or equal to the right height, we can calculate trapped water at the left pointer and move it right.
    // 2. Otherwise, calculate trapped water at the right pointer and move it left.

    // The trapped water at each pointer can be calculated similarly:
    // trapped_water = max⁡(0,current_max−height[𝑝𝑜𝑖𝑛𝑡𝑒𝑟]);

    public int trap(int[] height) {
        int left=0, right=height.length-1;
        int leftMax=0, rightMax=0;
        int totalWater = 0;


        // while(left<right){
        //     if(height[left]<=height[right]){
        //         if(leftMax>height[left])
        //             totalWater += leftMax-height[left];
        //         else
        //             leftMax = height[left]; 
                
        //         left++;
        //     }else{
        //         if(rightMax>height[right])
        //             totalWater += rightMax-height[right];
        //         else
        //             rightMax = height[right];
                    
        //         right--;
        //     }
        // }


        while(left<right){
            if(height[left]<=height[right]){ // Height on right is more so process left
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            }else{ // Height on left is more so process right
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }
        return totalWater;
    }
}
