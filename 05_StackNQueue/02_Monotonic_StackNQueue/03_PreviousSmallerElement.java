class Solution {

  public int[] prevSmaller(int[] A) {
    
      int[] result = new int[A.length];
      Stack<Integer> st = new Stack<>();
      
      for (int i = 0; i < A.length; i++) {

          // If top is greater than or equal to a[i] - then pop
          while (!st.isEmpty() && st.peek() >= A[i]) {
              st.pop();
          }

        
          // If stack is not empty - set a[i] as PSE
          // We have 2 ways to write - by if statement or by using ternary operator
          // Alternatively we can also initialize the result[] with -1 at the beginning
          if (st.isEmpty()) 
              result[i] = -1;
            else
              result[i] = st.peek();
          // OR  
          // result[i] = !st.isEmpty()? st.peek():-1;
          
          st.push(A[i]);
      }
      return result;
  }
}
