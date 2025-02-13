class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    // TC - O(N) 
	
    // Step1: Enqueue x to q2.
    // Step2: One by one dequeue everything from q1 and enqueue to q2.
    // Step3: Swap the queues of q1 and q2.
    void push(int a)
    {
	    // Your code here
	    q2.add(a); // Add the element 
	    
	    while(!q1.isEmpty()){
	        q2.add(q1.remove());
	    }
	    
	    Queue<Integer> q = q1;
	    q1 = q2;
	    q2 = q;
	    
    }
    
    //Function to pop an element from stack using two queues. 
    // TC - O(1)
    // Dequeue the element from Q1 and return it
    int pop()
    {
	    // Your code here
	    // if no elements are there in q1
        if (q1.isEmpty())
            return -1;
            
        return q1.remove();
    }
}
