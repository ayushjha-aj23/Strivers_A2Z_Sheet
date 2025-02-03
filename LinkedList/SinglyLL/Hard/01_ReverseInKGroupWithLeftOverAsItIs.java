/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// We have 3 Approaches - Iterative, Recursive, Stack or Queue

// Algorithm
// 1. temp = head;
// 2. Find out the kth Node
// 3. Preserve the next group head (it is Kth Node's next) as NextNode
// 4. Make the last element of the Kth Group point to null so it is an individual list now
// 5. Reverse the k-group LL (Pass it to the Reverse Function)
// 6. Update the head with the Kth node (or the last node of the group)
// 7. Before moving to the next Group again remember the node so as to link it to the head of new Group

// Repeat the process 

// And once we are left with less than K elements then just simply link the prevNode to the head of the left-out-node's head


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1 - Take temp = head;
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(temp!=null){
            // Step 2 - Find the Kth Node if exist
            ListNode KthNode = findKthNode(temp, k);

            // If we don't have KthNode or if list is smaller than Kth Node 
            if(KthNode==null){
                // if we are left over with less than K nodes then just link it to the prevNode next and break the loop
                if(prevNode!=null){ // If previous Node exist then 
                    prevNode.next = temp;
                } 
                // otherwise list is smaller then k nodes from the beginning and just break
                break;
            }
            // Step 3 - If Kth Node exist then cut out the K Nodes as individual group
            // If Kth Node exist then  
            nextNode = KthNode.next; // Store the nextNode after Kth Group
            KthNode.next = null; // Make the next of Kth Node points to null so we treat it as individual group 

            // Step 4 - Call the Reverse function and reverse the K-Group
            reverseList(temp);

            // Step 5 - The group that we have reversed is your 1st group or not
            // If temp == head, then it is 1st group then change the head and make new head equal to Kth Node
            // If it is not 1st group then 

            if(temp==head){ // For 1st Group
                head = KthNode; // Make the new head
            }else{  // For next Groups 
                prevNode.next = KthNode; // Link it to the previousGroup
            }

            // Move temp to the head of the new Group (or we can say nextNode) but before moving head store temp as it will be linked to the next Group
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode findKthNode(ListNode head, int k){
        ListNode temp = head;
        int positionofKthNode = 1;
        while(temp!=null && positionofKthNode<k){
            temp = temp.next;
            positionofKthNode++;
        }
        return temp;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
    
    while (current != null) {
        ListNode temp = current.next;  // Store the next node
        current.next = prev;           // Reverse the current node's link
        prev = current;                // Move prev one step forward
        current = temp;                // Move current node one step forward
    }
    
    return prev;  // After the loop, prev will be the new head of the reversed list
    }
}
