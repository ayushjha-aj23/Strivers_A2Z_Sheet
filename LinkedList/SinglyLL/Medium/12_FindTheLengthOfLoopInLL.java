/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

// Function should return the length of the loop in LL.
class Solution {
// Naive Approach - Using Hashing 
    // Function to find the length of a loop in the linked list.
    /*
    public int countNodesinLoop(Node head) {
        // Add your code here.
        
        HashMap<Node, Integer> mapNode = new HashMap<>();
        
        Node temp = head;
        int timer = 1;
        
        while(temp!=null){
            if(mapNode.containsKey(temp)){
                int value = mapNode.get(temp);
                return timer-value;
            }
            mapNode.put(temp, timer);
            timer++;
            temp = temp.next;
        }
        
        return 0;
    }
    */
    
    
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast){
                int countNodesInLoop = 1;
                slow = slow.next; // Move 1 step and start count by 1, we can use slow or fast anyone for the traversal in the loop to find the length
                while(slow!=fast){
                    slow = slow.next;
                    countNodesInLoop++;
                }
                return countNodesInLoop;
            }
        }
        return 0;
    }
    
}
