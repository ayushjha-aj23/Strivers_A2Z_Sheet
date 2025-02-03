/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        
        // Empty List
        if(head == null) 
            return head;
        
        // Case 1: Deleting the head node
        if (x == 1) {
            // If the list has only one node
            if (head.next == null) {
                return null; // Deleting the only node, return null
            }
            
            // Special case: if there are exactly two nodes, delete the head
            if (head.next != null && head.next.next == null) {
                head.next.prev = null; // Unlink the previous pointer of the second node
                return head.next; // The second node becomes the new head
            }
            
            
            Node temp = head;
            head = head.next; // Move the head to the next node
            head.prev = null; // Set the new head's prev to null
            return head; // Return the new head
        }
            
        
        Node temp = head;
        int position = 1;
        
        // Traverse to the node at position x
        while(temp != null && position < x){
            temp = temp.next;
            position++;
        }
        
        
        if (temp.next != null) {
            temp.next.prev = temp.prev; // Update the prev pointer of the next node
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next; // Update the next pointer of the previous node
        }
        
        return head;
    }
}
