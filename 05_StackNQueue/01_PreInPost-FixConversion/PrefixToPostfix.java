// User function Template for Java

class Solution {
    
    
    // Step1: Take a Stack of String type
    // Step2: Reverse the String and then Iterate till the length of the String
    // Step3: If character is operand ---> Convert it to String and Push it into the Stack
    // Step4: If character is operator ---> Take the last 2 elements of the Stack and insert operator after them as ---> last + secondLast + operator
    // Step5: Push the new String again back into the Stack 
    // Step6: At last only 1 element will be there in the stack ---> Return it as it is the converted Infix Expression 
    
    
    static String preToPost(String pre_exp) {
        // code here
        
        
        String temp = new StringBuilder(pre_exp).reverse().toString();
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<temp.length(); i++){
            char c = temp.charAt(i);
            if( (c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }else{
                String last = st.pop();
                String secondLast = st.pop();
                
                String newString = last + secondLast + c;
                st.push(newString);
            }
        }
        return st.pop();
    }
}
