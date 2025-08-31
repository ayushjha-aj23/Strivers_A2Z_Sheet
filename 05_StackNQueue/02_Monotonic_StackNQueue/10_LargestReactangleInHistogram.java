// LC-84, GFG, Striver

class Solution {
    /*
    // Naive Approach 
    // 1. Compute NSE for each bar - For each index i, look to the left until you find a bar shorter than heights[i]
    // 2. Compute PSE for each bar - For each index i, look to the right until you find a bar shorter than heights[i]
    // 3. Calculate area for bar -  
    // FORMULA - arr[i]*(nse[i]-pse[i]-1)
    // Math.max(maxArea, arr[i]*(nse[i]-pse[i]-1))

    // store index and not value
    public static int[] findNSE(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		
		// [1,3] -> Stack mae 3 hai then 1 jayega kyu ki 3 se chota hai
		// [5,3] -> Stack mae 3 hai then 5 nahi jayega
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
				st.pop();
			}
			result[i] = st.isEmpty()? n:st.peek();	
			st.push(i);
		}
		return result;	
	}

    // store index and not value
    public static int[] findPSE(int[] nums){
        int n = nums.length;
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!st.isEmpty() && nums[st.peek()]>=nums[i]) {
				st.pop();
			}
			result[i] = st.isEmpty()? -1:st.peek();
			st.push(i);
		}
		return result;
	}

    public int largestRectangleArea(int[] heights) {
        
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);
        
        // Calculate max area
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int area = heights[i]*(nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    */

    
    // Optimised Approach - 
    // TC - O(N)-For Traversal + O(N)-For At Max poping from the Stack
    // SC - O(N)
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        // FORMULA - arr[i]*(nse[i]-pse[i]-1)
        // Math.max(maxArea, arr[i]*(nse[i]-pse[i]-1))

        // Traverse 
        for(int i=0; i<n; i++){

            // Condition for Finding PSE
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element = st.peek(); // Store top
                st.pop(); // Remove from Stack

                int nse = i;
                int pse = st.isEmpty()? -1:st.peek(); 
                // Now the top left after removal from the Stack is the PSE

                maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
            }

            st.push(i); // Now push the Current index
        }

            // Those left over elements who do not have NSE for sure and might not PSE
            while(!st.isEmpty()){
                int element = st.peek();
                st.pop();

                int nse = n;
                int pse = st.isEmpty()? -1:st.peek();

                maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
            }

        return maxArea;
    }

}
