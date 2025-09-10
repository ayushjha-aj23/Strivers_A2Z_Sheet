// LC-146, GFG, Striver
// LRU Cache Data Structur Design 


// This is an Implementation Heavy Problem
// Structure of Doubly Linked List's Node
class Node{
    Node prev;
    int key, value;
    Node next;

    // Constructor of DLL
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}


// TC-O(1) and SC-O(capacity)
class LRUCache {

    // Declared Globally
    HashMap<Integer, Node> hashMap = new HashMap<>();
    int capacity;
    Node head, tail; // Dummy Nodes 

    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap.clear();

        // Initialization of Dummy Head and Tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // To delete a node
    void deletionOfNode(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }

    // To insert a node after head
    void insertionAfterHead(Node node){
        Node currentAfterHead = head.next;
        head.next = node;
        node.next = currentAfterHead;
        currentAfterHead.prev = node;
        node.prev = head;
    } 

    
    public int get(int key) {
        // If doesn't contains
        if(!hashMap.containsKey(key))
            return -1;
        
        // Otherwise store the node and return the value afterwards
        Node node = hashMap.get(key);

        // Delete it from the current position and insert it after the head 
        deletionOfNode(node);
        insertionAfterHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        
        // If key already exists -> Update the value
        if(hashMap.containsKey(key)){
            Node node = hashMap.get(key);
            node.value = value; // update the value

            // Delete it from the current position and insert it after the head 
            deletionOfNode(node);
            insertionAfterHead(node);
        }else{
            // If capacity is full delete the last node
            if(hashMap.size()==capacity){
                Node node = tail.prev;
                hashMap.remove(node.key);
                deletionOfNode(node);
            }

            Node node = new Node(key, value);
            hashMap.put(key, node);
            insertionAfterHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
