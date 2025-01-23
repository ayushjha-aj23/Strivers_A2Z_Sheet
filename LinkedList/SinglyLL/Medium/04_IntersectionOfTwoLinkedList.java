/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Naive Approach - Using Hashing 
    // TC - O(N1+N2) and SC - O(N1) or O(N2)
    // Function to find intersection point in Y shaped Linked Lists.
    /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        HashMap<ListNode, Integer> mapNode = new HashMap<>();

        // LL1 to traverse and then store in a Map
        while(temp!=null){
            mapNode.put(temp, 1);
            temp = temp.next;
        }

        // change temp
        temp = headB;

        // LL2 to traverse and find if node is present or not
        while(temp!=null){
            if(mapNode.containsKey(temp))
                return temp;
            
            temp = temp.next;
        }
        return null;
    }
    */

    // Optimised Approach - Without using Store
    // Function to find intersection point in Y shaped Linked Lists.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthL1 = length(headA);
        int lengthL2 = length(headB);
        
        int d = Math.abs(lengthL1 - lengthL2);
        
        if(lengthL1>lengthL2)
            return collisionPoint(headA, headB, d);
        else
            return collisionPoint(headB, headA, d);
    }

    // Find the Length of the Linked List 
    int length(ListNode head){
        ListNode temp = head;
            
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    // Collision Point
    ListNode collisionPoint(ListNode temp1, ListNode temp2,int d){
        while(d>0){
            temp1 = temp1.next;
            d--;
        }
        
        // Move both pointers in sync until they collide
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1; // Intersection point found
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null; // No intersection found
    }
}
