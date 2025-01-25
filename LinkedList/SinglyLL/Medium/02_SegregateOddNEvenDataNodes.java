// GFG
// User function Template for Java

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node divide(Node head) {
        // code here
        
        // If no node or single node is present in the list
        if(head == null || head.next == null)
            return head;
        
        Node evenStart = new Node(-1);
        Node oddStart  = new Node(-1);
        
        Node evenEnd = evenStart;
        Node oddEnd  = oddStart;
        
        Node temp = head;
        
        while(temp != null){
            int data = temp.data;
            
            if(data%2==0){
                evenEnd.next = temp;
                evenEnd = evenEnd.next;
            }else{
                oddEnd.next = temp;
                oddEnd  = oddEnd.next;
            }
            
            temp = temp.next;
        }
        
        oddEnd.next = null; // As it is the last node
        
        // Link the odd list after the end of the even list
        evenEnd.next = oddStart.next;
        
        return evenStart.next;
    }
}
