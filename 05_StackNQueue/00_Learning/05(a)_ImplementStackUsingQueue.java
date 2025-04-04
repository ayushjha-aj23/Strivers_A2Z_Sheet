    // We have to make the Queue behave in such a way that it behaves as a Stack 
    // As Top must always give the Last Stored Element as LIFO for Stack 


    // E.g. - Push(4), Push(9), Push(2), Push(5), top, pop, pop, top, push(1), top
    // Step1: [4] -> Top is same 4

    // Step2: [4, 9] -> Top is right now 4 because of queue but we have to implement
    // stack so our Output must be 9 therefore we will place all the element after 9
    // Step2b:[9, 4] -> Now top is 9 - CORRECT
    
    // Step3: [9, 4, 2] -> Top is 9 but it must be 2 so place all the other after 2
    // Step3b:[4, 2, 9] ----> [2, 9, 4] ---> Now the top is 2 - CORRECT

    // Step4: [2, 9, 4, 5] ---> Top is 2 but it must be 5 so again do the same
    // [9, 4, 5, 2]->[4, 5, 2, 9]->[5, 2, 9, 4]-> Now top is 5 - CORRECT

    // Step5: Top - 5
    // Step6: Pop - 5 --- [2, 9, 4]
    // Step7: Pop - 2 --- [9, 4]
    // Step8: Top - 9
    // Step9: Push(1) --- [9, 4, 1] -Top is 9 but it is not correct so again do same
    // [4, 1, 9]-[1, 9, 4] - Now top is 1 - CORRECT

    // Step10: Top - 1

    // TO DO - After every push make sure to place all the previous elements after entered element

class MyStack {
    Queue<Integer> q;
    public MyStack() {
       q = new LinkedList<>(); // Inbuilt Library Function
    }

    // TC - O(N)
    public void push(int x) {
        int size = q.size(); // Find the size of Queue before adding the element
        
        q.add(x); 

        for(int i=0; i<size; i++){
            q.add(q.remove()); // Move all elements behind the new element
            // Remove the element from the front of the Queue and add it back from behind
            // q.remove();
        }
    }

    // TC - O(1)
    public int pop() {
        return q.remove();
    }

     // TC - O(1)
    public int top() {
        return q.peek();
    }

     // TC - O(1)
    public boolean empty() {
        return q.isEmpty(); // Use isEmpty() to check if the queue is empty
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
