// Lc - Palindrome Linked List
// Same on GFG as well
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

    // 1. Using Stack - TC-O(N) and SC-O(1)
    /*
    public boolean isPalindrome(ListNode head) {
        if(head.next==null)
            return true;
        
        Stack<Integer> stack = new Stack<>();
        
        ListNode temp = head;
        
        // Push in the Stack
        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }
        
        // Traverse LL again, now check head and stack top if they are equal or not
        temp = head;
        while(temp!=null){
            int topOfStack = stack.pop();
            if(temp.val!= topOfStack)
                return false;
            else
                temp = temp.next;
        }
        
        return true;
    }
    */

    // 2. Using Recursion - TC-O(N) and SC-O(N)
    /*
    public boolean isPalindrome(ListNode head) {
        
    }
    */

    // 3. Using Iteration - TC-O(N) and SC-O(1)
    public boolean isPalindrome(ListNode head) {
        // Step 1: Find the middle of the LL - Use Tortoise and Hare 
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse of the Second half
        ListNode newHead = reverse(slow.next); // slow.next will be the position of staring of 2nd half
        
        
        // Step 3: Now comparing using 2 Pointers
        ListNode first = head;
        ListNode second = newHead;
        
        while(second!=null){
            if(first.val!=second.val){
                reverse(newHead);
                return false;
            }
            else{
                first = first.next;
                second = second.next;
            }
        }
        
        reverse(newHead);
        return true;
    }
    
    // Function to reverse the linked list
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
}
