// Remove K Digits - LC-402, GFG, Striver

class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();


        // Edge Cases - 
        // 1. If after traversal we are left with k then remove left over k from the last 
        // 2. If K==N or Stack is Empty - return "0"
        // 3. If result = "00100" then correct result is "100" so remove 0

        // After all this stack contains the resultant string but in reverse order so 
        // Append the top element and then reverse the result and then convert it into String

        for(char c: num.toCharArray()){
            
            // stack not empty, k>0, top>current element
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop(); // Remove the top of the stack
                k--; // Decrease K 
            }

            if (!st.isEmpty() || c != '0')
                st.push(c);
        }

        // If the entire traversal is done but k is left then pop the elements from the last and decrement k
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        // If stack is empty then result is 0
        if(st.isEmpty())
            return "0";
        

        // Reverse from the stack to get the result
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}
