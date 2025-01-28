// GFG

/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        
        
        // Key Points and Edge Cases
        // 1. When deleting the head node
        // 2. When deleting the middle node
        // 3. When deleting the tail node
        // 4. Ensure that nextToTemp doesn't go out of bounds.
        
        Node prevToTemp;
        Node temp = head;
        Node nextToTemp;
        
        
        while(temp!=null){
            nextToTemp = temp.next; // Update nextToTemp 
            
            if(temp.data==x){ // Check key
                if(temp==head){ // Check key and if it is head
                    head = head.next; // Update and move head by 1
                }
                
                nextToTemp = temp.next; // Update nextToTemp
                prevToTemp = temp.prev; // Update prevToTemp
                
                
                if(nextToTemp!=null)
                    nextToTemp.prev = prevToTemp; // Next Node's prev = Previous node
                if(prevToTemp!=null)
                    prevToTemp.next = nextToTemp; // Prev Node's next = Next Node
                
                temp = nextToTemp; // Update and move temp
            }else{
                temp = temp.next; // If temp.data is not key then simply move temp
            }
        }
        return head;
    }
}
