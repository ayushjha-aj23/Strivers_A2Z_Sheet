// Step 1: Reverse the given expression (Swap the '(' to ')' and vice versa)
// Step 2: Convert the Infix to Postfix expression
// Step 3: Reverse the result again 

    // Convert infix expression to prefix notation
    static String convertToPrefix(String infix) {
        StringBuilder s = new StringBuilder(infix);
        s = s.reverse();
        infix = s.toString();
        
        char[] chars = infix.toCharArray();
        
        for(int i=0; i<chars.length; i++){
            if(chars[i]=='(')
                chars[i] = ')';
            else if(chars[i]==')')
                chars[i] = '(';
        }
        infix = new String(chars);
        
        String postfix = convertInfixToPostfix(infix);
        return new StringBuilder(postfix).reverse().toString();
    }

    // Convert infix expression to postfix notation
    static String convertInfixToPostfix(String s) {
        
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
                while(!st.isEmpty() && priority(c) <= priority(st.peek()) ){
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

    // Priority of operators
    static int priority(char c){
        if(c=='^')
            return 3;
        else if(c=='*' || c=='/')
            return 2;
        else if(c=='+' || c=='-')
            return 1;
        else 
            return -1;
    }
