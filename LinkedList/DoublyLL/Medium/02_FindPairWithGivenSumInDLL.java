/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    
    // Naive Appraoch - Nested Loop and traverse
    // TC - O(N2)
    /*
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        
        // HashMap<Integer> a = new HashMap<>();
        Node temp1 = head;
        Node temp2 = head.next;
        
        
        ArrayList<ArrayList<Integer>> resultantPair = new ArrayList<>();
        
        
        while(temp1!=null){
            temp2 = temp1.next; // Move temp2 to next of temp1 everytime
            while(temp2!=null){
                if(temp1.data+temp2.data==target){
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(temp1.data);
                    a.add(temp2.data);
                    
                    resultantPair.add(a);
                    
                    // or we can do it directly without creating a new ArrayList
                    // mainList.add(new ArrayList<>(List.of(7, 8, 9)));
                }
                temp2 = temp2.next;
            }
            
            temp1 = temp1.next;
        }
        
        return resultantPair;
    }
    */
    
    // Better Approach - Using Hashing 
    // TC-O(N) and SC-O(N)
    /*
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        
        HashSet<Integer> hashSeen = new HashSet<>();
        ArrayList<ArrayList<Integer>> resultantPair = new ArrayList<>();
        
        Node temp = head;
        
        while(temp!=null){
            
            int complement = target-temp.data;
            
            if(hashSeen.contains(complement)){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(complement);
                a.add(temp.data);
                
                resultantPair.add(a);
            }
            
            hashSeen.add(temp.data);
            temp = temp.next;
        }
        
        // Sort the pairs
        // This part of code is required to sort the order because 
        // If we see 1st value is small and 2nd value is big
        Collections.sort(resultantPair, (pair1, pair2) -> {
            if (pair1.get(0).equals(pair2.get(0))) {
                return pair1.get(1).compareTo(pair2.get(1));
            }
            return pair1.get(0).compareTo(pair2.get(0));
        });
        
        return resultantPair;
    }
    */
    
    
    // Optimised Approach - Using 2 Pointer
    // TC - O(N) 
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        
        Node left = head;
        Node right = null;
        Node temp = head;
        ArrayList<ArrayList<Integer>> resultantPair = new ArrayList<>();
        
        
        // Traverse and assign the last node to Node right 
        while(temp!=null){
            if(temp.next==null)
                right = temp;
            temp = temp.next;
        }
        
        while(left.data<right.data){
            int sum = left.data+right.data;
            if(sum==target){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(left.data);
                a.add(right.data);
                    
                resultantPair.add(a);
                
                left = left.next;
                right = right.prev;
            }else if(sum>target){
                right = right.prev; // 
            }else if(sum<target){
                left = left.next;
            }
        }
        return resultantPair;
    }
}
