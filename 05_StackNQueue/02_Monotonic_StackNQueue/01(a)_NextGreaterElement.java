// GFG - Next Greater Element (NGE) 

class Solution {

    // NEXT GREATER ELEMENT
    // Next Greater Element(NGE) of some element x in an array is the first greater element that is to the right of x 
    // in the same array and if not then defualt we can take as -1
    // E.g. - Input - [2,3,6,4], Output - [3, 6, -1, -1]
    
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

    // Optimised Approach - O(N) 
    // Step 1: Initialize the Result array
    // Step 2: Use a Stack 
    // Step 3: Iterate over the array 
    //     a. Pop elements from the stack  
    //     b. If stack is not empty - set peek as NGE
    //     c. Always push a[i] in the stack
    
    
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


    // We can do 1 thing - Either Initialize the result with -1 or else inisde the for loop -> if stack is empty set -1
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

         for(int i=0; i<n; i++){
            result.add(-1);
        }
        
        for(int i=n-1; i>=0; i--){
            
            while(!st.isEmpty() && (st.peek()<=arr[i])){
                st.pop();
            }

            result.set(i, st.isEmpty()? -1: st.peek());
    
            st.push(arr[i]);
        }   
        return result;
    } 
}
