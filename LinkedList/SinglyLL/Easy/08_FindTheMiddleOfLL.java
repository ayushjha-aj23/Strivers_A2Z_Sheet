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
class Solution {
    // Naive Approach - This is a 2 pass solution having TC - O(n+(n/2)) can we do it in 1 pass
    /*
    public ListNode middleNode(ListNode head) {
        
        if(head==null && head.next==null)
            return head;
        
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }

        int middle = (count/2)+1;
        int c=1;
        temp = head;
        while(temp!=null && c<middle){
            c++;
            temp = temp.next;
        }

        return temp;
    }
    */

    // Optimised Approach - Tortoise and Hare Method - 1 pass
    // Concept of Slow and Fast Pointer
    public ListNode middleNode(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow = slow.next; // Move by 1
            fast = fast.next.next; // Move by 2
        }
        return slow;
    }
}
