class Solution {
    
    /*
    // Method 1: Brute Force Approach - TC O(N logN + N) (Sort+Loop)
    public int getSecondLargest(int[] arr) {
    // Code Here
        
        Arrays.sort(arr);
        // int secondLargest;
        
        // As we are sure that last element will be the largest 
        // So we will traverse the loop from 2nd last position
        
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] != arr[arr.length-1]) // Not equal to Largest
            {
                // secondLargest = arr[i];
                // break;
                return arr[i];
            }
        }
        
        return -1;
    }
    */
    
    
    /*
    // Method 2: Better - TC O(N+N) - (1st Pass n 2nd Pass)
    public int getSecondLargest(int[] arr) {
        // Code Here
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = -1;
        
        if(arr.length==1 ||(arr.length==2 && arr[0]==arr[1]))
            return -1;
        
        
        // For Finding the Largest Element
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest)
                largest = arr[i];
        }
        
        // For Finding the Second Largest Element
        for(int i=0;i<arr.length;i++){
            if(arr[i]>secondLargest && arr[i]!=largest)
                secondLargest = arr[i];
        }
        
        return secondLargest;
    }
    */
    
    
    // Method 3: Optimised - TC - O(N)
    public int getSecondLargest(int[] arr) {
        // Code Here
        
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        
        
        if(arr.length==1 ||(arr.length==2 && arr[0]==arr[1]))
            return -1;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                secondLargest = largest; // Assign Largest to 2nd Largest before updating
                largest = arr[i];
            }
            
            if(arr[i]<largest && arr[i]>secondLargest)
                secondLargest = arr[i];
        }
        
        return secondLargest;
    }
    
    
}
