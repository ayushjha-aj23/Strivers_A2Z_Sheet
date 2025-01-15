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
    // Reversing the Linked List can be done in 3 ways - Iterative, Recursive or through Stack
    // Optimised Way - Iterative Approach - TC-O(N) and SC-O(1)
    // Recursion – O(n) Time and O(n) Space
    // Stack – O(n) Time and O(n) Space

    // Either we can reverse the data(value) or we can reverse the links 
    // Reversing the links is optimal as compared to data

    // Iterative Approach - Reversing the Links
    //    1->2->3->4->5->X
    // X<-1<-2<-3<-4<-5
    
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
    


    // Recursion – O(n) Time and O(n) Space
    /*
    public ListNode reverseList(ListNode head) {
        // 1->2->3->4->5->X
        // X<-1<-2<-3<-4<-5
        // base case 
        if(head==null || head.next==null)
            return head;
        
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        // OR we can write 
        // ListNode headsNext = head.next;
        // headsNext.next = head; 
        // head.next = null;

        return newHead;
    }
    */
    
    // Stack – O(n) Time and O(n) Space
    /*
    public ListNode reverseList(ListNode head) {
        
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        
        while(temp!= null){
            stack.push(temp);
            temp = temp.next;
        }
        
        temp = head;
        
        // If the list is empty, return null
        if (stack.isEmpty()) {
            return null;
        }
            
        head = stack.pop();
        temp = head;
        
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        
        // Set the next of the last node as null
        temp.next = null;
        
        return head;
    }
    */ 
    
}
