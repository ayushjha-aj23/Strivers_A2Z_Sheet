class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        
        if(head==null || head.next==null)
            return head;
        
        Node temp = head;
        // Node previous = null;
        Node nextNode = temp.next;
        
        
        // TC - Looks like O(N2) but it is N as 
        // Outer Loop runs - for unique nodes
        // Inner Loop runs - for duplicate nodes 
        // So over all TC is O(N) only
        while(temp!=null && temp.next!=null){
            nextNode = temp.next;
            while(nextNode!=null && nextNode.data==temp.data){
                nextNode = nextNode.next;
                
            }
            temp.next = nextNode;
            if(nextNode!=null){
                nextNode.prev = temp;
            }
            
            temp = temp.next;
        }
        return head;
        
    }
}
