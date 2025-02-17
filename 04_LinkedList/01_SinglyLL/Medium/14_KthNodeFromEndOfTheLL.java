/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    /*
    int getKthFromLast(Node head, int K) {
        // Your code here
        
        // 1 Node and K=1
        if(head.next==null&&K==1)
            return head.data;
        
        Node temp = head;
        
        // Count the number of nodes
        int count = 0;
        while(temp!= null){
            count++;
            temp = temp.next;
        }

        // If C==K means return the value of Head
        if(count==K)
            return head.data;
        else if(count<K){ // K
            return -1;
        }


        // Traverse to the node just before the node to be deleted to join it to next of next 
        //Eg -if 5th node to be deleted traverse till 4 node and join it by 6th node
        temp = head;
        int a = 1;
        while(temp!=null && a<count-K){//c-n+1 is node to be deleted and c-n ka next
            temp = temp.next;
            a++;
        }
        
        return temp.next.data;
    }
    */
    
    
    // Optimsied Approach - 1 Pass - Using Fast and Slow Pointers
    int getKthFromLast(Node head, int K) {
        // Your code here
       
        // // Node 1 and K==Length
        // if(head.next==null && K==1)
        //     return head.data;
        
        
        Node fast = head;
        Node slow = head;
        
        for(int i=1; i<K; i++){
            fast = fast.next;
            
            if (fast == null) 
                return -1;  // K is greater than the length of the list
            
            
        }
        
        // // Node>1 and K==Length
        // if(fast==null)
        //     return head.data;
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.data;
    }
}
