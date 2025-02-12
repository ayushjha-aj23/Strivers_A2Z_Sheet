/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public int GetNth(Node head, int index) {
        // Code here
        
        Node temp = head;
        
        int i=1;
        while (i<=index && temp != null){
            if(i==index) 
                return temp.data;
            else{
                temp = temp.next;
                i++;
            }
        }
        
        return -1;
    }
}
