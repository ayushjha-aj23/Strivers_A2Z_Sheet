/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        
        Node temp = head;
        Node newNode = new Node(x); // New Node to be Inserted
        
        // Insertion at the beginning before head
        if(x<temp.data){
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        
        
        // Traverse the list to find the correct position for x
        while(temp.next != null && x>temp.next.data){
            temp = temp.next;
        }
        
        // Insert in between temp and temp.next
        newNode.next = temp.next;  // This may be null if inserting at the end
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    
        return head;
        
        
        // // Not the last node and x is smaller than temp data
        // if(temp != null && temp.next != null && x < temp.data){
        //     Node previous = temp.prev;

        //     // Backward Link(s)
        //     previous.next = newNode;
        //     newNode.prev = previous;
        //     // Forward Link(s)
        //     newNode.next = temp;
        //     temp.prev = newNode;
        // }else{                      // Insertion at the end
        //     // temp = head;
        //     // while(temp.next!=null)
        //     // {
        //     //     temp = temp.next;
                
        //     // }
        //     // Backward Link(s)
        //     temp.next = newNode;
        //     newNode.prev = temp;
        //     // Forward Link(s)
        //     newNode.next = null;
        // }
        
        // return head;
    }
}
