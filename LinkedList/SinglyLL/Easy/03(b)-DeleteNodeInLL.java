// LC-237

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // Conditions 
    // 1. Node to be deleted is not the last node, so it always has next node.
    // 2. By copying the value of the next node into the current node, we effectively "overwrite" the value of the current node with the next node's value.
    // 3. We cannot access the head node
    // 4. We need to remove the node from the list - i.e. Just adjust the links
    public void deleteNode(ListNode node) {
        
        // Copy the value from the next node to the current node
        node.val = node.next.val;
        // Skip the next node by linking the current node to the next of next node
        node.next = node.next.next;
    }
}
