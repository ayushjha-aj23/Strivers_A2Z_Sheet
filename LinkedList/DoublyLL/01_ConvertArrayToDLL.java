// User function Template for Java
class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        
        // Edge case for empty array
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        Node dLL = arrayToDLL(arr);
        return dLL;
    }
    
    private Node arrayToDLL(int arr[]){
        
        Node head = new Node(arr[0]);
        Node prev = head;
        
        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            newNode.prev = prev;
            prev.next = newNode;
            prev = newNode; // OR  prev = prev.next to Move Forward the Prev
        }
        
        return head;
    }
}
