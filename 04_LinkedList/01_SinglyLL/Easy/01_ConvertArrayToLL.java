// --- GFG - Array to Linked List--- 
// Dificuly - Easy

// User function Template for Java

/*
class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
*/

/*
class Solution {
  // Naive Solution - appending each node one by one at the end and then displaying 
  // TC-O(N2) and SC-O(N)
  // Better to go for Optimised Solution directly
    static Node constructLL(int arr[]) {
        // code here
        
        // Convert the array to a linked list
        Node root = arrayToList(arr);
        return root;
    }
    
    // Method to convert an array to a linked list
    public static Node arrayToList(int[] arr) {
        Node root = null;  // Initialize the root (head) of the linked list

        // Iterate through the array and insert each element into the linked list
        for (int i = 0; i < arr.length; i++) {
            root = insertEnd(root, arr[i]);
        }

        return root;  // Return the root of the linked list
    }

    // Helper method to insert a new node at the end of the linked list
    public static Node insertEnd(Node root, int item) {
        Node temp = new Node(item);  // Create a new node with the given data
        
        if (root == null) {
            return temp;  // If the list is empty, return the new node as the head
        }

        Node last = root;
        // Traverse to the last node of the list
        while (last.next != null) {
            last = last.next;
        }

        // Append the new node to the end of the list
        last.next = temp;

        return root;  // Return the root node
    }

    // Method to display the linked list
    public static void display(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");  // Print the data of the current node
            root = root.next;  // Move to the next node
        }
        System.out.println();  // Print a newline at the end
    }
}
*/



// ----- Optimised Approach ---
// TC-O(N) and SC-O(N)
// Remember the Concept of Dummy Node
class Solution {
     static Node constructLL(int arr[]) {
        // code here
        Node dummy = new Node(-1);
        Node current = dummy;
        
        for(int i=0; i<arr.length; i++){
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return dummy.next;
    }
}
