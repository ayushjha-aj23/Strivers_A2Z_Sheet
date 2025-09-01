// LC-85, Max Reactangle, Striver


class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        // If matrix in Invalid for calculation
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        // Taking preSum for making a new matrix which is PrefixSum matrix of the given matrix
        int [][] preSum = new int[n][m];

        // If we have to traverse sideways towards right then i's loop and inner loop is j's loop
        // We have to go and traverse downwards so that is why j's loop and inner loop is i's loop
        for(int j=0; j<m; j++){
            int sum = 0;

            for(int i=0; i<n; i++){
                sum += matrix[i][j] - '0'; // Subtracting it from 0 to make it int value from char
                // Method 2: char ch = '1'; int num = Character.getNumericValue(ch);

                if(matrix[i][j]=='0') // Because it 0 then no bar will be drawn as we want only 1's
                    sum = 0;
                
                preSum[i][j] = sum;
            }
        }


        // For each row, treat it as a histogram and calculate max area
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, largestHistogram(preSum[i]));
        }

        return maxArea;
    }

    // Formaula -> arr[i]*(nse[i]-pse[i]-1);
    private int largestHistogram(int arr[]){
        
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){

                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty()? -1:st.peek();

                maxArea = Math.max(maxArea, arr[element]*(nse-pse-1));
            }

            st.push(i);
        }

        // Left Over Elements
        while(!st.isEmpty()){
            
            int element = st.peek();
            st.pop();
            int nse = n;
            int pse = st.isEmpty()? -1:st.peek();

            maxArea = Math.max(maxArea, arr[element]*(nse-pse-1));
        }

        return maxArea;
    }
}
