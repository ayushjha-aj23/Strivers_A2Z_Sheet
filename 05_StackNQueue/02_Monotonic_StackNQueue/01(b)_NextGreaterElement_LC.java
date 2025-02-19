class Solution {

    //Step 1: Use Hashmap and find the NGE for all the value of num2---Num2, NGE
    //Step 2: Using map get only value which maps or equals with nums1 and store their corresponding NGE in the result array  

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n2 = nums2.length;

        for(int i=n2-1; i>=0; i--){

            // If top is less than current
            while(!st.isEmpty() && (st.peek()<= nums2[i]))
                st.pop();
            
            // If top is greater than current then set it as NGE
            nextGreaterMap.put(nums2[i], st.isEmpty()? -1 : st.peek());
            
            // Always push the element to the stack
            st.push(nums2[i]);
        }

        // Build the result array now only for nums1 elements using map
        int n1 = nums1.length;
        int[] result = new int[n1];
        for(int i=0; i<n1; i++){
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        return result;
    }
}
