class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    // 
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    
    
    StackNode top; // Right now pointing to null
    int size = 0;
    
    // TC and SC is O(1) and here as it is dynamic so the SC is much less than in case of Array Implementation

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        
        // We will not check overflow here becuase here stack is dynamic in nature
        
        StackNode newNode = new StackNode(a); // Create new Node
        newNode.next = top; // NewNode pointing to top ---> For Stack-New Over the old Stack Node
        top = newNode; // Update top as newNode ---> To point to current node i.e. Top
        size++; // Increase the size
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        
        // Check if the stack is empty or not - UNDERFLOW
        if(top==null) return -1;
        
        StackNode temp = top; // Store top in temp 
        // and move top to next and temp will automatically be discarded by Garbage Collector 
        top = top.next; // Move top to point to next node here next node means the node below the current node
        size--; // Decrease the size
        
        return temp.data; // Return the data of poped element
    }
    
    int top(){
        // Check if the stack is empty or not - UNDERFLOW
        if(top==null) return -1;
        return top.data;
    }
    
    int sizeofStack(){
        return size;
    }
    
}
