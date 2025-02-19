class Solution {
    
    // Approach1: Nested For Loop - TC-O(N2)
    /*
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Initialize result with -1 for all elements
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        
        // Compare ith element with j (i.e. i+1 element) 
        // If j>i then set the result for ith as jth element and break 
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]<arr[j]){
                    result.set(i, arr[j]);
                    break;
                }
            }
        }
          
        return result;
    }
    */
    
    
    
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Initialize result with -1 for all elements
        for(int i=0; i<n; i++){
            result.add(-1);
        }
        
        // If we traverse from the left then we don't know the options which can be the greater 
        // So we Traverse from the back i.e. right so we always have options to tell which can be the next greater
        for(int i=n-1; i>=0; i--){
            
            // If stack top is less than current element then pop the element(s)
            while(!st.isEmpty() && (st.peek()<=arr[i])){
                st.pop();
            }
            
            // If stack top is greater than set it as NGE 
            // If stack is not empty the top element is the Next Greater Element
            if(!st.isEmpty())
                result.set(i, st.peek()); // Set top element as the NGE for Current Element    
            
            // ALways push the current element to the stack
            // Push the current element onto the stack
            st.push(arr[i]);
        }   
        return result;
    } 
}
