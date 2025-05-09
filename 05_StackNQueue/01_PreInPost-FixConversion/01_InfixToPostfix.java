class Solution {
    
    // Step 1: Take Char stack, iterator(i) and result of type string
    // Step 2: Iterate till the end of the string
    // Step 3: If character is Operand ---> Simply add it to the result
    // Step 4: If character is '(' ---> Push into the Stack
    // Stap 5: If character is ')' ---> Add every operator from the stack to the result till it reaches '('
    // Step 6: If character is Operator 
    // Step 6: a. If priority of current character is less than top of Stack ---> Pop and add the operators to result till the priority of top is less than current
    // Step 7: b. If priority of current character is greater than top ---> Push it into the Stack
    // Step 8: After the while loop is over ---> Check and add all the remaining operators from the stack till its empty
    // Step 9: Return result

    // Hamesha zada priority vala upar aasakta hai kam priority vale ke but reverse is not possible
    // Stack - +, *, (, ^ and current element is -> + then it can't be pushed ---- So pop
    // Stack - +, * ----> Current is -> ^ then it can come over * --- So push
    
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        
        Stack<Character> st = new Stack<>();
        String result = "";
        int lengthOfS = s.length();
        int i = 0;
        
        while(i<lengthOfS){
            char c = s.charAt(i);
            if( (c >='A' && c <='Z') || (c >='a' && c <='z') || (c >='0' && c <='9') ){
                result += c;
            }else if(c =='('){
                st.push(c);
            }else if(c ==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    result += st.pop(); // st.top() and then st.pop()
                }
                st.pop();
                // st.pop() outside the while loop is necessary to remove the opening parenthesis '(' from the stack.
            }else{
                while(!st.isEmpty() && (priority(c) <= priority(st.peek())) ){
                    result += st.pop();
                }
                st.push(c);
            }
            i++;
        }
        
        while(!st.isEmpty()){
            result += st.pop();
        }
        
        return result;
    }
    
    public static int priority(char c){
        if(c=='^')
            return 3;
        else if(c=='*' || c=='/')
            return 2;
        else if(c=='+' || c=='-')
            return 1;
        else 
            return -1;
    }
}
