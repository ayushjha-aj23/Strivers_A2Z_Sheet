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

    // Naive Approach with Array or List using Traversal
    /*
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        List<Integer> a = new ArrayList<>();

        while(temp!= null){
            a.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(a);
        
        temp = head;
        int i =0;
        while(temp!= null && i<a.size()){
            temp.val = a.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }
    */


    // There are 2 ways to sort the list - 
    // 1. Naive - Bubble Sort - O(N2)
    /*
    public ListNode sortList(ListNode head) {
        
        // Check if null or 1 node 
        if(head == null || head.next == null)
            return head;
        
        boolean swapped;
        do{
            swapped = false;
            ListNode temp = head;

            while(temp!=null && temp.next!=null){
                if(temp.val>temp.next.val){
                    int swapVal = temp.val;
                    temp.val = temp.next.val;
                    temp.next.val = swapVal;
                }
                temp = temp.next;
                swapped = true;
            }
        }while(swapped); // Check till swapped is false i.e. it reaches end

        return head;
    }
    */
    
    // 2. Optimised - Merge Sort - O(N log N) - Divide and Conquer and Combine
    // For this we 1st need to understand how to find the middle element in LL
    // Step - 1 Find the middle
    // Step - 2 Recursively Sort
    // Step - 3 Merge the two sorted list
    
    public ListNode sortList(ListNode head) {
        
        // Base case: If the list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step -1: Find middle and then and Split the List
        ListNode middle = middleNode(head);

        // 1,2,3,4
        // righthead = 3->4->X
        // leftHead  = 1->2->X
        // Always assign rightHead first and then assign to leftHead
        
        ListNode rightHead = middle.next;
        middle.next = null; // 1st half now having last element as null
        ListNode leftHead = head;

        // Step -2: Recursively Sort the two halves
        leftHead = sortList(leftHead); // 1st half
        rightHead = sortList(rightHead); // 2nd half

        // Step -3: Merge the sorted halves
        return merge(leftHead, rightHead);
    }

    private ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next; // We have change from head to head.next because we need fast pointer is 1 place ahead and slow pointer is 1 place behind 
        // We this because if ---> 1, 2, 3, 4 
        // it will give middle as 3 but we need middle as 2 so that 
        // 2 LinkedList are - 1->2->X and 3->4->X


        while(fast!=null&&fast.next!=null){
            slow = slow.next; // Move by 1
            fast = fast.next.next; // Move by 2
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right){

        if(left==null) return right;
        if(right==null) return left;

        ListNode mergedHead = null;

        // Use a pointer to build the merged list
        if (left.val <= right.val) {
            mergedHead = left;
            left = left.next;
        } else {
            mergedHead = right;
            right = right.next;
        }

        ListNode mergedTail = mergedHead;

        // Merge the remaining nodes
        while (left != null && right != null) {
            if (left.val <= right.val) {
                mergedTail.next = left;
                left = left.next;
            } else {
                mergedTail.next = right;
                right = right.next;
            }
            mergedTail = mergedTail.next;
        }

        // If there are any remaining nodes in either list, append them
        if (left != null) {
            mergedTail.next = left;
        } else if (right != null) {
            mergedTail.next = right;
        }

        return mergedHead;
    }
    
}
