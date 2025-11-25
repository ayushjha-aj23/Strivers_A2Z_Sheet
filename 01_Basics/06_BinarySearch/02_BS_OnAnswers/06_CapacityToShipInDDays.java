
// LC - 1011

class Solution {

    // min weight capacity = max(weights)
    // max weigth capacity = sum of all weights -> only 1 day
    // Range - [1, sum(weights)]

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
                sum = weights[i]; // Update sum with the new weight and forget all the previous
                days++; // Update days
            }    
        }
        return days;
    }
}
