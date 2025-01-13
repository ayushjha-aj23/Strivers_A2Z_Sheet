class Solution {
    // Naive Approach- Using extra space as ArrayList 
    /*
    // Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        
        List<Integer> a = new ArrayList<>();
        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                a.add(temp1.data);
                temp1 = temp1.next;
            }
            else{
                a.add(temp2.data);
                temp2 = temp2.next;
            }
        }
        
        while(temp1!=null){
            a.add(temp1.data);
            temp1 = temp1.next;
        }
        
        while(temp2!=null){
            a.add(temp2.data);
            temp2 = temp2.next;
        }
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        int i=0;
        while(i<a.size()){
            current.next =new Node(a.get(i) );
            i++;
            current = current.next;
        }
        return dummy.next;
    }
    */

    // optimised Approach
    // Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
    
        // Create a dummy node to help with merging
        Node dummy = new Node(0);
        Node current = dummy;
        
        // Traverse both lists and merge them
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;  // Link current node to head1
                head1 = head1.next;  // Move to the next node in head1
            } else {
                current.next = head2;  // Link current node to head2
                head2 = head2.next;  // Move to the next node in head2
            }
            current = current.next;  // Move current to the next node
        }
        
        // If one list is still non-empty, append it
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
    
        // Return the merged list, starting from the next node of dummy
        return dummy.next;
    }
