class Solution {

    // Here’s how you can implement this:
    // Step 1: Initialize a stack: Use a list to simulate the stack.
    // Step 2: Create a mapping: Define a mapping of closing brackets to their corresponding opening brackets.
    // Step 3: Iterate through the string: For each character in the string:
    //  a. If it’s an opening bracket ((, {, [), push it onto the stack.
    //  b. If it’s a closing bracket (), }, ]):
    //     - Check if the stack is empty. If it is, return false (because there’s no opening bracket).
    //     - If the stack is not empty, pop the top of the stack and check if it matches the current closing bracket using the mapping.
    //  Step 4: Final check: After processing all characters, if the stack is empty, return true (all brackets matched), otherwise return false.

// TC-O(N) and SC-O(N)
    public static boolean isValid(String s) {
        // Mapping of closing brackets to opening brackets
        char[] openBrackets = {'(', '{', '['};
        char[] closeBrackets = {')', '}', ']'};
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Check if it's an opening bracket
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Check if it's a closing bracket
            else if (c == ')' || c == '}' || c == ']') {
                // If stack is empty or top of stack doesn't match
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop(); // Or we can do in 2 steps
                // char top = stack.top() and then pop it out, stack.pop() 

                 // Current Char is '(' and Top is not ')'
                if( (c==']' && top!='[') ||
                    (c=='}' && top!='{') ||
                    (c==')' && top!='(') ){
                       return false;
                }

                // OR We can create a seperate function to test it 
                // if (!isMatchingPair(top, c)) {
                //     return false;
                // }
            }
        }
        // If the stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }

    // private static boolean isMatchingPair(char open, char close) {
    //     return (open == '(' && close == ')') || 
    //            (open == '{' && close == '}') || 
    //            (open == '[' && close == ']');
    // }
}
