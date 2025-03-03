class Solution {


    // public void nextPermutation(int[] nums) {
        
    // }

    // Brute Force Approach
    // Step 1: Generate all the Permutations in Sorted Order
    // Step 2: Linear Search for the given Input 
    // Step 3: The next index of it will be our answer
    // Lecture 12 and 13 with the help of Recursion
    // Time Complexity will be very high as only generating all the permutations
    // Will take -> N!*N time like if 5 elements then -> 5! or 120 then each of length 5
    
    /*
    void nextPermutation(int[] arr) {
        // code here
    }
    */
    
    // Optimised Approach - 
    // Step 1: Larger Prefix Match ---Loop from Last-a[i] < a[i+1] --- Breaking Point
    // Step 2: Find > breaking point but the smallest one because we need just next greater
    // Step 3: Sort the remaining elements in ascending order 
    
    // Special Case - If there is no dip like we are given the highest permutation
    // E.g. arr = [1, 2, 3] highest combination is [3, 2, 1] so it can't have next permutation 
    // so we will give [1,2,3] as the answer in case of [3, 2, 1]
    // Take breakPoint as -1 and return the reverse of the input
    
    public void nextPermutation(int[] arr) {
        // code here
        
        int n = arr.length;
        int breakPoint = -1;
        
        // Step 1: Find the largest prefix match
        for(int i=n-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                breakPoint = i;
                break;
            }
        }
        
        if(breakPoint==-1)
            reverse(arr, 0, n-1);
        else{
             // Step 2: Find the next greater to arr[i]
            for(int i=n-1;i>=breakPoint;i--){
                if(arr[i]>arr[breakPoint]){
                    swap(arr, i, breakPoint);
                    break;
                }
            }
        
            // Step 3: Sort the remaining elements in ascending order
            // As we know it is already sorted in increasing order 
            // We can do only reverse to get the remaining elements in sorted order.
            reverse(arr, breakPoint+1, n-1);
        }
        
    }
    
    private void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    
    // Function to reverse the part of the array from 'start' to 'end'
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move the pointers towards the center
            start++;
            end--;
        }
    }
    
}
