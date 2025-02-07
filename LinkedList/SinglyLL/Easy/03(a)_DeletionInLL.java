// Program to Delete a Node from the LL if the value or data match with any nodes data 
// It checks for - Null List, At Head, In the Middle, and at the end of the LL


public class LinkedList {
    Node head;

    // Delete node function: handles all deletion cases
    public void deleteNode(int value) {
        // Case 1: Empty list
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        // Case 2: Delete the head node
        if (head.data == value) {
            head = head.next; // Move the head pointer to the next node
            System.out.println("Deleted the head node with value: " + value);
            return;
        }

        // Case 3: Delete from the middle or tail
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data == value) {
                temp.next = temp.next.next; // Skip the node to delete
                System.out.println("Deleted node with value: " + value);
                return;
            }
            temp = temp.next;
        }

        // Case 4: Node not found
        System.out.println("Node with value " + value + " not found in the list.");
    }
