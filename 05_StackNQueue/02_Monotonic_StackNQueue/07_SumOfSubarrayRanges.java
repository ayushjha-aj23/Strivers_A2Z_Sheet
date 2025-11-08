
// Approach-1: Naive Approach - Find the range i.e. largest-smallet for every subarray
// TC - O(N2) and SC - O(1)
/*
class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        long range = 0;

        for(int i=0; i<n; i++){
            int largest = nums[i];
            int smallest = nums[i];

            for(int j=i; j<n; j++){ // We can take j=i+1 as single element subarray is giving 0 and of no use. Starting from i+1 and not i because i=0;j=0 -> arr[0] 
            // largest and smallest both are 1 if [1,2,3] and then its result is 0
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                range = range + (largest-smallest);
            }
        }
        return range;
    }
}
*/


// Approach-2: Optimised Approach -> Subarray Maximums-Subarray Minimums
// sumSubarrayMax(nums)-sumSubarrayMins(nums);
// For - sumSubarrayMax(nums) - we need NGE and PGEE
// For - sumSubarrayMins(nums) - we need NSE and PSEE

class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }


    private long sumSubarrayMins(int[] arr) {
        long totalSum = 0;
        int n = arr.length;
        //int mod = (int) 1e9+7;

        
        int[] nse = findNSE(arr); 
        int[] psee = findPSEE(arr); 
        

        for(int i=0; i<n; i++){
            int left = i-psee[i]; 
            int right = nse[i]-i; 
            // totalSum = (int) ((totalSum + (long)right * left * arr[i]) % mod);
            totalSum = (totalSum + ((long)right * left * arr[i]));
        }

        return totalSum;
    }

    // Fn to find the list of next smaller element
    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>(); 

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

           nse[i] = st.isEmpty() ? n : st.peek(); // If empty take n i.e. if no next smaller then take n (acts as boundary)
            st.push(i);
        }
        return nse;
    }

    // Fn to find the list of previous smaller or equal element
    public int[] findPSEE(int[] arr){
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();

            psee[i] = st.isEmpty() ? -1 : st.peek(); // If empty take -1 (acts as boundary)

            st.push(i);
        }
        return psee;
    }

    public long sumSubarrayMaxs(int[] arr) {
        long totalSum = 0;
        int n = arr.length;
        //int mod = (int) 1e9+7;

        int[] nge = findNGE(arr); 
        int[] pgee = findPGEE(arr); 

        for(int i=0; i<n; i++){
            int left = i-pgee[i]; 
            int right = nge[i]-i;

            // totalSum = (int) ((totalSum + (long)right * left * arr[i]) % mod);
            totalSum = (totalSum + ((long)right * left * arr[i]));
        }

        return totalSum;
    }

    // Fn to find the list of next greater element
    public int[] findNGE(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();

           nge[i] = st.isEmpty() ? n : st.peek(); // If empty take n i.e. if no next smaller then take n (acts as boundary)
            st.push(i);
        }
        return nge;
    }

    // Fn to find the list of previous greater or equal element
    public int[] findPGEE(int[] arr){
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i])
                st.pop();

            pgee[i] = st.isEmpty() ? -1 : st.peek(); // If empty take -1 (acts as boundary)
            st.push(i);
        }
        return pgee;
    }
}
