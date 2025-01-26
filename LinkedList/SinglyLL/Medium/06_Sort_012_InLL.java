/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    // Method 1: Naive Approach
    /*
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        
        Node temp = head;
        int countZero=0, countOne=0, countTwo=0;
        
        // 1st Pass
        // Count No. of 0's, 1's, n 2's
        while(temp != null){
           if(temp.data==0) countZero++;
           if(temp.data==1) countOne++;
           if(temp.data==2) countTwo++;
            
           temp = temp.next;
        }
        
        temp = head;
        
        // 2nd Pass
        // Now replace the data in the nodes
        while(temp!=null){
            if(countZero>0){
                temp.data = 0;
                countZero--;
            }else if(countOne>0){
                temp.data = 1;
                countOne--;
            }else if(countTwo>0){
                temp.data = 2;
                countTwo--;
            }
            temp = temp.next;
        }
        
        return head;
    }
    */
    
    // Method 2: Optimised Approach
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        
        if(head.next== null)
            return head;
        
        Node temp = head;
        
        // Dummy Nodes 
        Node Zero = new Node(-1);
        Node One = new Node(-1);
        Node Two = new Node(-1);
        
        
        // Pointers to the Head of our Dummy Node
        Node ZeroHead = Zero;
        Node OneHead = One;
        Node TwoHead = Two;
        
        while(temp != null){
            
            if(temp.data == 0){
                Zero.next = temp;
                Zero = Zero.next;
            }else if(temp.data == 1){
                One.next = temp;
                One = One.next;
            }else if(temp.data == 2){
                Two.next = temp;
                Two = Two.next;
            }
            
            temp = temp.next;
        }
        
        
        // Last 0 pointing to first 1 only if 1's are present
        if(OneHead.next != null)
            Zero.next = OneHead.next; 
        else
            Zero.next = TwoHead.next;
        
        
        //Last 1 pointing to first 2 only if 2's are present
        if(TwoHead.next != null)
            One.next = TwoHead.next; 
        else
            One.next = null;
        
        // Last 2 pointing to null which is obvious
        Two.next = null; 
        
        return ZeroHead.next;
    }
}
