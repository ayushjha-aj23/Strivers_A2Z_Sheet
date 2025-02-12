/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    int size = 0;
    
     // TC and SC is O(1) and here as it is dynamic so the SC is much less than in case of Array Implementation
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode newNode = new QueueNode(a);
        
        if(front==null){ // or rear==null means-If the Queue is empty and we are pushing the 1st element
            front = newNode;
            rear = newNode;
        }
        else{ // It is not the 1st element that is pushed
            rear.next = newNode; 
            rear = newNode; // Update the rear by NewNode
        }
        size++;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(front==null) return -1; // or rear==null means-Check if there exist an element or not or it is empty
        
        QueueNode temp = front; // Front element is to be removed as FIFO
        
        front = front.next;
        // Temp will be automatically removed by garbage collector
        size--;
        return temp.data;
	}
	
	int top(){
	    if(front==null) return -1;
	    return front.data;
	}
	
	int sizeOfQueue(){
	    return size;
	}
}
