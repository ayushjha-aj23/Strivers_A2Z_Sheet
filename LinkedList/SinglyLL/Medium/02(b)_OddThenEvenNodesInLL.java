// LC
// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]

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

    // Naive - TC-O(2N) and SC-O(N)
    /*
    public ListNode oddEvenList(ListNode head) {
        
        ListNode temp = head;
        List<Integer> OddEven = new ArrayList<>();

        // Edge Cases - head is null or single node
        if(head == null || head.next == null)
            return head;

        // For Odd
        while(temp != null && temp.next != null){
            OddEven.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) {OddEven.add(temp.val);} // E.g. - 1,2,3 then 3 might be missed as it will not go inside the loop 

        temp = head.next;
        
        // For Even
        while(temp != null && temp.next != null){
            OddEven.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) {OddEven.add(temp.val);} // E.g. - 1,2,3, 4 then 4 might be missed as it will not go inside the loop 

        temp = head;
        int i = 0;
        // Now convert list to Linked List
        while(temp != null){
            temp.val = OddEven.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }
    */

    // .Optmised - Tc - O(N) and SC - O(1)
    // In this we dont have to use external data structure 
    // So we will change the links in the given linked list itself
    
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next; // Memoize or remember it so that we can use it afterwards

        // We will write only for even as it will cover odd as well
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    } 
}
