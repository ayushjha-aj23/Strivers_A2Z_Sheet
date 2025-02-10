// User function Template for Java
class Solution {
    
    /*
    // Naive Approach - TC - O(a+b+c) and SC-O(d+e)
    // a - For Nested Traversal - N*M
    // b - For Sorting - Let X be N*M so -> X log X
    // c - For Storing - N*M
    
    // d - For Storing in ArrayList - N*M total node data
    // e - For Storing in LinkedList Node - N*M
    
    // So TC-O(2*(N*M) + X logX) and SC-O(2*(N*M))
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        
        // We can use array or arrayList here
        ArrayList<Integer> sortedNodesInList = new ArrayList<>();
        
        Node temp = root;
        
        while(temp!=null){
            Node tempInner = temp;
            while(tempInner!=null){
                sortedNodesInList.add(tempInner.data);
                tempInner = tempInner.bottom;
            }
            temp = temp.next;
        }
        Collections.sort(sortedNodesInList);
        
        // For Check 
        // for(int i : sortedNodesInList){
        //     System.out.print(i+" ");
        // }
        
        
        // Call the convert function it will convert the ArrayList into Linked List
        root = convertArrayListToLL(sortedNodesInList);
        return root;
    }
    
    Node convertArrayListToLL(ArrayList<Integer> a){
        Node dummy = new Node(-1);
        
        Node current = dummy;
        
        for(Integer i : a){
            current.bottom = new Node(i);
            current = current.bottom;
        }
        return dummy.bottom; 
        // We have used bottom everywhere because we need to link it in vertical fashion
        // Position of the head 
         // -1->1->2->3->4->5
    }
    */
    
    // Optimised Approach 
    
    // We will 1st see how to merge sort 2 LL vertically (Almost same as Merge 2 Sorted LL)
    // TC-O(N1+N2) 
    /*
    merge2LL(list1, list2){
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        while(list1!=null&&list2!=null){
            if(list1.data<list2.data){
                current.bottom = list1;
                list1 = list.bottom;
            }else{
                current.bottom = list2;
                list2 = list2.bottom;
            }
            
            current.next = null;
            current = current.bottom;
        }
        
        if(list1!=null)
            current.bottom = list1;
        else
            current.bottom = list2;
        
        return dummy.bottom;
    }
    */
    
    // Now when we can solve it for 2 LL then we can do it for mutiple LL as well
    // We will merge last 2 ll and make 1 then we will merge 3rd last with the new LL and this goes on
    // We will use the concept of recursion 
    
    // Optimised Approach 
    // TC-O(N*mergeSort) ---> O(N*(M+M)) ---> 2MN 
    // SC-O(N) becuase although we are not using any space but we are using recursive call stack space
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        
        // Recursively flatten the list and merge them
        recursiveCallToMergeSortedMutipleLL(root);
        return root;
    }
    
    Node recursiveCallToMergeSortedMutipleLL(Node root) {
        if(root==null || root.next==null)
            return root;
        
        Node mergedHead = flatten(root.next);
        return merge2SortedLL(root, mergedHead);
    }
    
    Node merge2SortedLL(Node list1, Node list2){
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        
        while(list1!=null&&list2!=null){
            if(list1.data<list2.data){
                current.bottom = list1; // Connect to the bottom pointer
                list1 = list1.bottom; // Move to the next node in list1
            }else{
                current.bottom = list2; // Connect to the bottom pointer
                list2 = list2.bottom; // Move to the next node in list2
            }
            
            current.next = null;
            current = current.bottom;
        }
        
        if(list1!=null)
            current.bottom = list1;
        else
            current.bottom = list2;
        
        return dummy.bottom;
    }
}
