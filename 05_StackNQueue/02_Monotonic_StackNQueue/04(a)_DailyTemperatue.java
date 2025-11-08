// LC-739
// Same as NGE - Store Index instead of Value

class Solution {

    // Time complexity: O(n) (each element pushed/popped at most once).
    // Space complexity: O(n) (stack + result).
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        // next greater temperature 
        // Pop indices with smaller or equal temperatures
        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }

            result[i] = st.isEmpty()? 0:st.peek()-i; // Peek Index - Current Index(i)
            st.push(i);
        }

        return result;
    }
}
