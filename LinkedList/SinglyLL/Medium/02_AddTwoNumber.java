

// LC - 002 Add Two Numbers
// Similar on GFG as well - Only change is write logic for reverse as well as reverse Num1, Num2 and also give the output in reverse order
// Function to reverse the linked list
    // static Node reverse(Node head) {
    //     Node prev = null;
    //     Node curr = head;
    //     Node next;

    //     while (curr != null) {
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }
// --------------------------------------
// LC - 002 Add Two Numbers
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

    // Using dummy node
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        int sum = 0;
        

        // Both must become null, null -> false i.e. both list reached the end
        while(t1 != null || t2 != null){
            
            sum = carry;
            
            if(t1 != null) {sum = sum + t1.val;}
            if(t2 != null) {sum = sum + t2.val;}
            
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            
            current.next = newNode;
            current = current.next;
            
            if(t1 != null) {t1 = t1.next;}
            if(t2 != null) {t2 = t2.next;}
            
        }
        
        
        // If only carry is left and both list reached null then do this
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        
        return dummyNode.next;
    }
}
