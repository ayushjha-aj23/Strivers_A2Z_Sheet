class Solution {

    // Same as Next Greater Element but in this we have to check in Circular Array
    // E.g. nums = [1, 2, 3, 4, 3]
    //    Output = [2, 3, 4, -1, 4]

    // Naive Approach - Nested Loops - TC-O(N2) and SC-O(N)
    // For Searching the NGE in Circular form we can use - (i%n)
    // Step 1: Set all the values of result as -1
    // Step 2: In Nested Loop - 
    // i -> 0 to N-1 and j -> 1 to N-1 
    //      if(a[i] < a[i+j]%n) ---> result[i] = a[i+j]%n) - Set it as NGE
    // Step 3: break the loop
    

    // Optimised Approach - Using Stack - TC-O(4N) and SC-O(2N + N)
    public int[] nextGreaterElements(int[] nums) {
        
        int aLen = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[aLen];

        // Make all the values of result as -1
        for(int i=0; i<aLen; i++){
            result[i] = -1;
        }

        // Iterate over the nums from right to left
        for(int i=2*aLen-1; i>=0; i--){

            // If top is less then current element --- pop the top of stack
            while(!st.isEmpty() && (st.peek()<=nums[i%aLen]) ){
                st.pop();
            }

            // if stack is not empty and i<n (we only need NGE for original elements in range)
            if(!st.isEmpty() && i<aLen)
                result[i] = st.peek();

            // OR we can write it as and remove the above for loop to initialize -1
            // if(i<n){
            //      result[i] = !st.isEmpty()? st.peek():-1; 
            // }

            // Always push the element to the stack 
            st.push(nums[i%aLen]);
        }

        return result;
    }
}
