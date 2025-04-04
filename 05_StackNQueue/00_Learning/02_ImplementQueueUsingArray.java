class MyQueue {

    int front, rear;
    int size = 100005;
	  int arr[] = new int[size];
	  int currentSize = 0;

    MyQueue()
	{
		front=-1;
		rear=-1;
	}

	// TC of all is -> O(1) and SC of all is -> O(1) but we are using space equal to size of array as static
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    
	   // Check if Queue is Overflow or not
	   //if(currentSize==size) 
	   //System.out.println("Queue is Overflow");
	   
	   if(currentSize==0){ // Means the Queue is empty then increase front n rear both
	        front=0;
	        rear=0;
	   }else{ // Means Queue has some elements then just increment the rear
	        rear = (rear+1)%size; 
	        // We are using modulo just to make the queue circular otherwise 
	        // currentSize will be less but array already have elements which we can't access
	   } 
	   arr[rear] = x; // Add the element
	   currentSize++; // Increase the current Size
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		
		// Check if Queue is Underflow or not
	    //if(currentSize==0) 
	    //System.out.println("Queue is Underflow");
		
	    if(currentSize==0) return -1; // Underflow
		
	   	if(currentSize==1){ // Means we are destroying the queue by removing this element
	   	    front = rear = -1;
	   	}else{ // Means we have more than 1 element and we are removing the front element
	   	    front = (front+1)%size;
	   	}
		
		int element = arr[front]; // LIFO so element to be removed is from front
	   	currentSize--; // Decrease the currentSize
	   	return element; // Return the element
	} 

  int frontPointer(){
    if(currentSize==0)
       //System.out.println("Queue is Underflow");
    return arr[front];
  }

int rearPointer(){
	return arr[rear];
}

  int size(){
    return currentSize;
  }
}
