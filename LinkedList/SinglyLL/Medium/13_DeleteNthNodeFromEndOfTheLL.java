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

    // Naive Approach - Using 2 Pass 
    // 1st Pass - Find the length of the LL
    // 2nd Pass - Traverse to the node just before the node to be deleted
    // Edge Cases - 4 Edge Cases - No Node, n=1 and Node=1, N=1 and Node>1, Count==N
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Contains No node so directly return head
        if(head==null)
            return head;
        
        // Means head to be deleted and it contains only 1 node
        if(head.next==null&&n==1)
            return null;
        
        ListNode temp = head;
        
        // Count the number of nodes
        int count = 0;
        while(temp!= null){
            count++;
            temp = temp.next;
        }

        // Means head to be deleted and it contains more than 1 node
        if(count==n)
            return head.next;


        // Traverse to the node just before the node to be deleted to join it to next of next 
        //Eg -if 5th node to be deleted traverse till 4 node and join it by 6th node
        temp = head;
        int a = 1;
        while(temp!=null && a<count-n){//c-n+1 is node to be deleted and c-n ka next
            temp = temp.next;
            a++;
        }

        // It will also check for last Node i.e. if N==1
        if(temp!=null && temp.next!=null)
            temp.next = temp.next.next;
        
        return head;
    }
    */


    // Optimised Approach - 1 Pass - Using Fast and Slow Pointer
     public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        ListNode slow = head;

        // First Move Fast Pointer by N steps
        for(int i=0; i<n; i++)
            fast = fast.next;
        
        // If fast pointer is null, we need to remove the head (n == length of list)
        if(fast==null)
            return head.next;

        // Then move slow and fast till fast.next is null and slow will reach the node just before the node to be deleted
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
     }
}
