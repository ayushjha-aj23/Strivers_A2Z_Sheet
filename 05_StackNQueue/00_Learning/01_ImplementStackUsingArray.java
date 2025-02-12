class MyStack {
    private int[] arr;
    private int top;
    int size = 1000;

    public MyStack() {
        arr = new int[size];
        top = -1;
    }

  // TC of all is -> O(1) and SC of all is -> O(1) i.e. the size of array as it is static in nature
    public void push(int x) {
        // Your Code
        
        // Check Overflow Error
        // if(top>=size) 
        // System.out.println("Stack Overflow"); 
            
        top++; // or top = top+1;
        arr[top] = x;
        
        // Instead of 2 lines we can say --> arr[++top] = x;
    }

    public int pop() {
        // Your Code
        
        // Check Overflow Error
        if(top==-1) return -1; // or we can say if(top<0) 
        // System.out.println("Stack Underflow"); 
        
        int x = arr[top]; 
        top--; // or top = top-1;
        // Instead of 2 lines we can say --> int x = arr[top--];
        return x;
    } // Generally pop function pops the element out from the stack without printing it in that case we will not return anything

  public int top(){
        // Check Overflow Error
        if(top==-1) return -1; // or we can say if(top<0) 
        // System.out.println("Stack Underflow"); 
    return arr[top];
  }
  public int size(){
      return top+1;
  }
}
