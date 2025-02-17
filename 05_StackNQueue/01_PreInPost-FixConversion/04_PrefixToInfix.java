// User function Template for Java

class Solution {
    
    // Step1: Take a Stack of String type
    // Step2: Iterate till the length of the String
    // Step3: If character is operand ---> Convert it to String and Push it into the Stack
    // Step4: If character is operator ---> Take the last 2 elements of the Stack and insert operator between them as ---> last + operator + secondLast
    // Step5: Push the new String again back into the Stack 
    // Step6: At last only 1 element will be there in the stack ---> Return it as it is the converted Infix Expression 
    
    
    static String preToInfix(String pre_exp) {
        // code here
        
        Stack<String> st = new Stack<>();
        int N = pre_exp.length();
        for(int i=N-1; i>=0; i--){
            char c = pre_exp.charAt(i);
            if( (c>='A'&& c<='Z') || (c>='a'&& c<='z') || (c>='0'&& c<='9')){
                st.push(Character.toString(c));
            }else{
                String last = st.pop();
                String secondLast = st.pop();
                
                String newString = "(" + last + c + secondLast + ")";
                st.push(newString);
            }
        }
        return st.pop();
    }
}
