class Solution {
    
    // // Method 1: Brute Force Approach - TC: O(N logN)
    // public static int largest(int[] arr) {
        
    //     Arrays.sort(arr); // Sorting takes N log N
    //     return arr[arr.length-1]; // Last Element
    // }    
    
    
    // Method 2: Optimised - TC: O(N) - Single Loop
    public static int largest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>largest)
                largest = arr[i];
        }
        
        return largest;
    }
}
