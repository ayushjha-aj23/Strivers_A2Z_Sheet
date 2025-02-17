// User function template for JAVA

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class Solution {
    
    // If there exist a min of 1 node in a LL from where you start and you reach back
    // Approach - Using Hashing and using Map data structure
    // Remember to store the whole node and not only the value becuase the data or value can repeat
    // Function to check if the linked list has a loop.
    /*
    public static boolean detectLoop(Node head) {
        // Add code here
        
        HashMap<Node, Integer> mapNode = new HashMap<>();
        
        Node temp = head;
        
        while(temp!=null){
            if(mapNode.containsKey(temp))
                return true;
            else
                mapNode.put(temp, 1);
            
            temp = temp.next;
        }
        return false;
    }
    */
    
    // Function to check if the linked list has a loop.
    // Optimised Approach - Using Tortoise and Hare method or slow and fast pointer
    public static boolean detectLoop(Node head) {
        
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast)
                return true;
        }
        return false;
    }
}
