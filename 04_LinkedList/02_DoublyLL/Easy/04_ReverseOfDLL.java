/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    
    // Brute Force - Push data of nodes into the stack and then pop them 
    // As Stack follows LIFO so our data will be reversed
    // In this we reverse the data through 2 passes
    
    // Optimised Approach -TC - O(n) and SC O(1)
    // In this we reverse the links through 1 pass
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head; // No change is needed, return the current head
        }
            
        DLLNode current = head;
        DLLNode temp = null;
        
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            
            current = current.prev; // To go to other node
        }
        return temp.prev; // This is the head now after reversing the links
    }
}
