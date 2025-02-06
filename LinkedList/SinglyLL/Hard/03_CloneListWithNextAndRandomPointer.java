/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // If we do not have the random pointer then copying was super simple but now
    // we have to create each node 1st with value

    // Naive Approach - TC-O(2N) and SC-O(N) + O(N)
    /*
    public Node copyRandomList(Node head) {
        Node temp = head;

        // Key -> Original and Value -> Copied
        HashMap<Node, Node> hashNode = new HashMap<>();

        //Step1: Create Dummy Node and Store Original and Copied Node in the HashMap
        while(temp!=null){
            Node newNode = new Node(temp.val);
            hashNode.put(temp, newNode);
            temp = temp.next;
        }

        // Step2: 
        temp = head;

        while(temp!=null){
            Node copiedNode = hashNode.get(temp);

            copiedNode.next = hashNode.get(temp.next);
            copiedNode.random = hashNode.get(temp.random);

            temp = temp.next;
        }

        return hashNode.get(head);

    }
    */

    // Optimised Approach - 
    // Step1: Create NewNode and plce them in between the original nodes 
    // Step2: Then connec the random pointers
    // Step3: Then think of connecting the next pointer
    public Node copyRandomList(Node head) {
        Node temp = head;

        // For Data
        // Create newNodes and place them in between the original nodes
        while(temp!=null){
            
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;

            // Move temp by 2 places
            temp = temp.next.next;
        }

        // For Random Pointers
        // Copy the random pointers from original to the new nodes
        temp = head;
        while(temp!=null){
            
            // 
            if(temp.random!=null)
                temp.next.random = temp.random.next;
            else
                temp.next.random = null;
                
            // Move temp by 2 places
            temp = temp.next.next;
        }

        // For Next Pointer
        // Copy the next Pointers from original to the new NOdes
        Node dummy = new Node(-1);
        Node result= dummy;

        temp = head;

        while(temp!=null){
            result.next = temp.next;  // Point to the copied node
            temp.next = temp.next.next; // Restore the next pointer of the original list
            result = result.next;  // Move 'result' forward
            temp = temp.next;  // Move 'temp' forward
        }
        return dummy.next;
    }
}
