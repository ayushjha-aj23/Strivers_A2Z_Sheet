class MyQueue {

    Stack<Integer> A;
    Stack<Integer> B;
    public MyQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    // Approach 1 - If push operations are less as compared to pop and top operations
    
    // A-->B - A vale stack ke sare B mae
    // x-->A - new elements A mae store karo
    // B-->A - pehle se sare dubara A mae store kar do
    public void push(int x) {
        
        while(A.size()>0){
            B.push(A.pop());
        }

        A.push(x);

        while(B.size()>0){
            A.push(B.pop());
        }
    }
    
    public int pop() {
        return A.pop();
    }
    
    public int peek() {
        return A.peek();
    }
    
    public boolean empty() {
        return A.isEmpty();
    }

    // Approach 2 - If more push operations than top and pop then use this approach
    public void push(int x) {
        A.push(x);
    }

    public int pop(){
        if(!B.isEmpty())
            return B.pop();
        else{
            while(A.size()>0){
                B.push(A.pop());
            }
            return B.pop();
        }
    }

    public int peek() {
        if(!B.isEmpty())
            return B.peek();
        else{
            while(A.size()>0)
                B.push(A.pop());
            return B.peek();
        }
    }
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
