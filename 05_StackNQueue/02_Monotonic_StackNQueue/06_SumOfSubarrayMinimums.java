
// Subarray - N*(N+1)/2
// Possible subarray of - [3, 1, 2, 4] --> 10 possible subarrays
// Starting with 3 - [3], [3,1], [3,1,2], [3,1,2,4]
// Starting with 1 - [1], [1,2], [1,2,4]
// Starting with 2 - [2], [2,4]
// Starting with 4 - [4]

// As the answer can be very large mod it with -> (10^9)+7


// Approach-1: Naive - Find all the possible subarrays and from every subarray find the minimum
// TC - O(N2) and SC - O(1)
/*
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        int mod = (int) (1e9+7);

        for(int i=0; i<n; i++){
            int min = arr[i]; // OR we can take -> int min = Integer.MAX_VALUE;

            for(int j=i; j<n; j++){
                min = Math.min(min, arr[j]);
                totalSum = (totalSum + min)%mod;
            }
        }

        return totalSum;
    }
}
*/


// Approach-2: 
// [3, 1, 2, 4] --> 10 possible subarrays --- Mini
// Starting with 3 - [3], [3,1], [3,1,2], [3,1,2,4] -> 3, 1, 1, 1
// Starting with 1 - [1], [1,2], [1,2,4] -> 1, 1, 1,
// Starting with 2 - [2], [2,4] -> 2, 2
// Starting with 4 - [4] -> 4
// 1-six times, 2-two times, 3-one time, 4-one time
// 6+4+3+4->17 

// The general intuition for solution to the problem is to find sum(A[i] * f(i))
// where f(i) is the number of subarrays in which A[i] is the minimum.

// For each element A[i], 
// we compute how far it can extend to the left and right while still being the minimum.
// left[i] - the number of consecutive elements to the left that are strictly greater than arr[i].
// right[i]- the number of consecutive elements to the right that are greater than or equal to arr[i].
// Previous Smaller Element and Next Smaller Element
// f(i) = left[i] × right[i]
// => The Contribution of arr[i] to the answer is arr[i]×left[i]×right[i]

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        int mod = (int) (1e9+7);
        
        int[] nse = findNSE(arr); //Array- to store list of next smaller elements
        int[] pse = findPSEE(arr); // Array - to store list of previous smaller or equal element

        for(int i=0; i<n; i++){
            int left = i-pse[i];
            int right = nse[i]-i;

            totalSum = (int)((totalSum + (long)right * left * arr[i]) % mod);
            // int - as final result is integer
            // long - as it might be a bigger value
        }

        return totalSum;
    }

    // Fn to find the list of next smaller element
    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>(); // For storing the index and not the next smaller value

        for(int i=n-1; i>=0; i--){

            // If top is greater than or equal to a[i] - then pop as we have more smaller value
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                //  System.out.println("Pop: top index " + st.peek() + ", arr[top] = " + arr[st.peek()] + ", arr[i]=" + arr[i]);
                st.pop();
            }

           nse[i] = st.isEmpty() ? n : st.peek(); // If empty take n
            st.push(i);
        }
        return nse;
    }

    // Fn to find the list of previous smaller or equal element
    public int[] findPSEE(int[] arr){
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>(); //For storing the index and (!) the prev smaller value

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){ //Here will not remove equal so only >
                // System.out.println("Pop: top index " + st.peek() + ", arr[top] = " + arr[st.peek()] + ", arr[i]=" + arr[i]);
                st.pop();
            }

            psee[i] = st.isEmpty() ? -1 : st.peek(); // If empty take -1
            // System.out.println("pse[" + i + "] = " + psee[i]);
            st.push(i);
        }
        return psee;
    }
}
