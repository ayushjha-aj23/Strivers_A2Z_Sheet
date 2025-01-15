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
  Node insertBeforeKey(Node head, int key, int newData) {
        if (head == null) 
            return null;
        // Special case: if the key is at the head
        if (head.data == key) {
            Node newNode = new Node(newData);
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

  // 3. 

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




