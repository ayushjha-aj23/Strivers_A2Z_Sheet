
// LC - 1011


// generic partitioning problem.
// You have:
// An array arr[]
// You want to divide it into at most K parts such that maximum sum of any part ≤ some limit (pages) and you want to check feasibility for a given limit.
// This exact check is used in:
//     Capacity to Ship Packages Within D Days
//     Allocate Minimum Number of Pages
//     Split Array Largest Sum
//     Painter’s Partition Problem

// Generic Partitioning Problem - Template
// Can we split arr[] into at most maxParts subarrays such that each subarray has sum <= limit ?
/*
public boolean canPartition(int[] arr, int maxParts, int limit) {
    int usedParts = 1;   // we start with first partition
    int currentSum = 0;

    for (int num : arr) {
        // impossible if a single element itself exceeds limit
        if (num > limit) return false;

        if (currentSum + num <= limit) {
            currentSum += num; // add to current partition
        } else {
            usedParts++; // need a new partition
            currentSum = num; // update currentSum as the new number

            // as soon as usedParts exceeds the maxParts then we must return false
            if (usedParts > maxParts) { 
                return false;
            }
        }
    }

    return true;
}
*/




class Solution {

    // min weight capacity = max(weights) from the whole array otherwise I can't ship that weight
    // max weigth capacity = sum of all weights -> In that case i will only need 1 day
    // Range - [max(weights), sum(weights)]

    // Optimised - BS on Anwers
    public int shipWithinDays(int[] weights, int days) {
        int low = maxOfWeights(weights);
        int high = sumOfWeights(weights);
        int result = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            int d = calDays(weights, mid);
            if(d<=days){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return result;
    }

    private int sumOfWeights(int[] weights){
        int sum = 0;
        for(int i: weights)
            sum += i;
        return sum;
    }

    private int maxOfWeights(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int i : weights)
            max = Math.max(max, i);
        return max;
    }

    private int calDays(int[] weights, int mid){
        // You always check if the current weight fits in todays capacity
        // If yes → accumulate
        // If not → move to next day
        // sum is reset to the current weight when starting a new day
        int n = weights.length;
        int sum = 0;
        int days = 1;
        for(int i=0; i<n; i++){
            if(sum+weights[i]<=mid)
                sum += weights[i]; // add weight till it is less then or equal to mid
            else{
                days++; // Increase the days count - As we need a new partition
                sum = weights[i]; // Update sum with the new weight and forget all the previous
            }    
        }
        return days;
    }
}
