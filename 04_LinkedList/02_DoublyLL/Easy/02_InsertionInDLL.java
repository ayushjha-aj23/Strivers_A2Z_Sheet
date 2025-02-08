import java.util.Scanner;

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
  
    // Insert at the beginning
    public void insertAtBeginning(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    // Insert after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        newNode.prev = prevNode;
    }

    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node newNode = new Node(x);
        
        if(head == null){ // Empty DLL{
            if(p==0) // Empty List and position is 0 
                return newNode;
            return head; // Empty List and positon is more than 0
        }
        Node temp = head;
        int position = 0;
        
        while(temp != null && position < p){
            temp = temp.next;
            position++;
        }
        newNode.next = temp.next; // NewNode ka Next to Temp ka Next se
        newNode.prev = temp; // NewNode ka prev to Temp ke Prev se
        if(temp.next!= null)
            temp.next.prev = newNode; // If current.next is not null, update prev of next node
        
        temp.next = newNode; // Temp ka next to NewNode as it is after
        return head;
    }

    // Print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
