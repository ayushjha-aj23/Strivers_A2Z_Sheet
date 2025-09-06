// LC-239, GFG, Striver

class Solution {

    // Naive Approach - Using Nested Loops
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){

            int max = nums[i];
            for(int j=0; j<k; j++){
                max = Math.max(max, nums[i+j]);
            }

            result[i] = max;
        }
        return result;
    }
    */


    // Optimised Approach - Using Dequeu and maintaing decreasing order in window elements

    // Why we uses Deque and not Queue
    // Remove elements that go out of the window (from the front ✅ → Queue can do this).
    // Remove elements from the back if they are smaller than the current element (because they’ll never be the maximum). ❌ → Queue cannot do this efficiently.

    // is it inside my window or not
    // is it more than current stored in queue or not
    // The deque stores indices, not values.
    // Monotonic Stack -> It maintains a monotonically decreasing order of values.
    // Front of the deque always holds the index of maximum element in the current window.


    // TC - O(2N)
    // SC - O(N) -> at any point we are not storing more than 

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        // traverse the array
        for(int i=0; i<n; i++){

            // Maintain the window size and remove the indices which are out of current window
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst(); // Remove from current window
            }

            // Remove smaller elements from the stack
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            // Add new index
            dq.offerLast(i);

            // Add the max element of current window to the result
            if(i>=k-1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
