// Insertion in Linked List 
// Inserting a new node in the given LL can have 5 variations - 
// a. At the front of the LL. --- Beginning
// b. Before a given node.
// c. After a given node.
// d. At a specific position.
// e. At the end of the linked list.

// class Node {
//     int data;
//     Node next;

//     Node(int new_data) {
//         data = new_data;
//         next = null;
//     }
// }

class Solution {
  
  // 1. Insert at the front of the linked list
  Node insertAtFront(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
  }
  
  // 2. Insert before a given node
  Node insertBeforeKey(Node head, int key, int x) {
        if (head == null) 
            return null;
        // Special case: if the key is at the head
        if (head.data == key) {
            Node newNode = new Node(x);
            newNode.next = head;
            return newNode;
        }

        // Initialize current and previous pointers
        Node temp = head;
        Node prev = null;

        // Traverse the list to find the key
        while (temp != null && prev.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If the key was found
        if (temp != null) {
            Node newNode = new Node(newData);
            newNode.next = temp;  // NewNode->4->5->6
            prev.next = newNode;  // 1->2->3->NewNode->4->5->6
        }
        return head;
    }

  // 3. Insert a new node after a given node
  Node insertAfter(Node head, int key, int x) {
        Node temp = head;

        // Iterate over Linked List to find the key and when found break the loop
        while (temp != null) {
            if (temp.data == key)
                break;
            temp = temp.next;
        }
    
        // if temp becomes null means, given key is not found in linked list
        if (temp == null)
            return head;
        
        // Create new node by given data and point the next of newNode to temp next & then point temp next to newNode
        Node newNode = new Node(x);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

  // 4. Insert at the specified position
  Node insertAtPosition(Node head, int position, int x){
        if (position <= 0) return null; // Invalid position
        
        Node newNode = new Node(x);

        // If inserting at the front (position 1)
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node temp = head;
        int count = 1;

        // Traverse the list to find the node just before the position
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        // If position is valid, insert the new node
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return head;
  }

  // 5. Insert a node at the end of the linked list.
  Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        // Check if head is null or not 
        if(head==null)
            return newNode;
        // If head is not null traverse till the last node of the Linked List 
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        // Then append the newNode at the End of the last node and return the head
        last.next = newNode;
        return head;
    }

static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
}
  
  


