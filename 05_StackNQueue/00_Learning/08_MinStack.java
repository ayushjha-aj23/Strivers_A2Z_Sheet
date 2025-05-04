// Approach 1 - Using Pair to store inside a stack 
// TC - O(1) and SC - O(2N) as it is a pair
/*
class MinStack {

    Stack<Pair<Integer, Integer>> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        // We are pushing the first element then min value will also be that element
        if(st.isEmpty()){
            st.push(new Pair<>(val, val));
        }else{
            st.push(new Pair<> (val, Math.min(val, st.peek().getValue() ))); 
            // Push val and minimum from val and stack.top second 
        } 
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().getKey();
    }
    
    public int getMin() {
        return st.peek().getValue(); // Here st.top() is the internal method and its second part
    }
}
*/

class MinStack {

    Stack<Long> st;
    long minElement;
    // Problem with int minElement 1 test case is failing better to take so taking Long type for Stack 

    public MinStack() {
        st = new Stack<>();
        minElement = Long.MAX_VALUE;
    }
    
    public void push(int v) {
        long val = Long.valueOf(v); // Type casting value of from int to long
        if(st.isEmpty()){
            minElement = val;
            st.push(val);
        }else{
            if(val<minElement){ // If new Value to be pushed is smaller than minElement
                st.push(2*val-minElement); // Push 2*Val-minElement in Stack
                minElement = val; // Update minElement by new Value
            }else{ // If new Value to be pushed is greater than currect minElement
                st.push(val);
            }
        }
    }
    
    public void pop() {
        
        if(st.isEmpty()) return; // If stack is empty just return

        long temp = st.pop(); // Store the poped element 

        // If temp is smaller then minElement then we have to modify minElement too
        if(temp<minElement){
            minElement = 2*minElement-temp;
        }
    }
    
    public int top() {

        if(st.isEmpty()) return -1;

        long temp = st.peek(); //We use peek() because calling internal peek()

        // If temp is smaller then minElement then actual top is equal to minElement
        if(temp<minElement)
            return (int) minElement;
        else // If temp is greater then minElement then actual top is top of stack
            return (int) temp;
    }
    
    public int getMin() {
        if(st.isEmpty()) 
            return -1;
            
        return (int) minElement;
    }
    // Here we didn't check is stack is empty or not IDK
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
