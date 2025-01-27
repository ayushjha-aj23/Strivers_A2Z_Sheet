// GFG - Find the first node of loop in linked list
// LC - 142 - Linked List Cycle II


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Naive Approach - Hashing using map
    // TC - O(2N) and SC-O(N)
    /*
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> mapNode = new HashMap<>();

        ListNode temp = head;
        while(temp!=null){
            if(mapNode.containsKey(temp))
                return temp;
            else
                mapNode.put(temp, 1);
            
            temp = temp.next;
        }
        return null;
    }
    */


    // Optimised Approach - Using Tortoise and Hare Method
    // TC - O(N) and SC-O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // return slow or fast
            }
        }
        return null;
    }
}
