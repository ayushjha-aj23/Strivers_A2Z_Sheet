// *************************Right Rotation*************************
// LC

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
    public ListNode rotateRight(ListNode head, int k) {

        // Check if head is null or we have only 1 node or if k=0
        if(head==null || head.next==null || k == 0)
            return head;

        ListNode temp = head;
        int lengthOfLL = 1; // Let initial length be 1

        // Traverse to find the Length of the LL
        while(temp.next!=null){ // Traverse till temp.next!=null
            temp = temp.next;
            lengthOfLL++;
        }
        // System.out.println("Length of LL is - "+lengthOfLL);

        // Make it circular
        temp.next = head;

        // If k is greater than length of LL then use modulus
        k = k%lengthOfLL;

        // Position of New Tail 
        int newTailPos = lengthOfLL-k;

        // System.out.println("Position of New Tail is - "+newTailPos);

        ListNode newTail = head;
        int counter = 1;
        // Traverse till the newTail
        while(newTail!=null && counter<newTailPos){
            newTail = newTail.next;
            counter++;
        }
        // System.out.println("Value in temp right now"+newTail.val);
        ListNode newHead = newTail.next; // Store the newHead 
        newTail.next = null; // As temp is now new tail so make it to null
        return newHead;

    }
}
