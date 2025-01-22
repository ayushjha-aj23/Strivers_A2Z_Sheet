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

// There are 2 ways - Iterative and Recursive way 
// Iterative - Pro - No extra Space 
//             Con - More time taken, and tempering of data
// Recursive - Pro - No tampering of data, In-place Addition
//             con - Extra Stack space

// Using Iterative Approach by Reverse
// TC - O(3N) and SC-O(1) 
// 3N - Reversing, Traversing and then again Reversing
/*
class Solution {
    
    
    public Node addOne(Node head) {
        // code here.
        
        Node temp = head;
        temp = reverseList(temp);
        
        Node current = temp;
         // Why we use current also apart from temp 
        // temp: Used for reversing the list and performing the addition of 1 in the least significant digit first.
        // current: Used after the addition to either continue traversing the list for carry handling or to find the last node if a new node is required.

        
        int carry = 1; // As we have to add 1 to the number represented by nodes
        while(carry!=0 && current!=null){
            int newData = current.data+carry;
            if(newData==10){
                current.data = 0;
                carry = 1;
            }else{
                current.data = newData;
                carry = 0;
                // break; 
            }
            current = current.next;
        }
        
        head = reverseList(temp);
        
        // If carry is still 1, we need to add a new node at the end
        // E.g. - 9999+1->10000
        // If carry is still 1, we need to add a new node at the end
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    
    public Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
    
        while (current != null) {
            Node temp = current.next;       // Store the next node
            current.next = prev;           // Reverse the current node's link
            prev = current;               // Move prev one step forward
            current = temp;              // Move current node one step forward
        }
        
        return prev;  // After the loop, prev will be the new head of the reversed list
    }
    
}
*/


// Using Recursion and Backtracking
// TC - O(N) and SC - O(N)
// SC is O(N) as data is stored in recursive stack space
class Solution {
    
    public Node addOne(Node head) {
        // code here.
        
        int carry = addOneHelper(head);
        
        if(carry==1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        
        return head;
    }
    
    int addOneHelper(Node head){
        
        Node temp = head;
        // Base Case -> Go deep till the end i.e. till temp becomes null
        if(temp==null)
            return 1;
        
        // If base case is not reached then just move forward and traverse
        int carry = addOneHelper(temp.next);
        
        temp.data = temp.data+carry;
        if(temp.data<10) // temp.data<10
            return 0;
        else{ // temp.data = 10
            temp.data = 0;
            return 1;
        } 
    }
}
