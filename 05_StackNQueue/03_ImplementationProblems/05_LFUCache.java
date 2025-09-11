
// LC-460, GFG, Striver


/*
In LFU (Least Frequently Used) Cache eviction works like this:
1. Find the node with the smallest frequency count.
    Each key keeps track of how many times it’s been accessed (freq).
2. If multiple nodes have the same minimum frequency: (LRU plays a role as Tie-Breaker)
    Evict the one that was used least recently among them.

So it falls back to LRU policy within the same frequency bucket.

Primary criteria → least frequency
Secondary criteria (tie-breaker) → least recently used

That’s why LFU is trickier to implement than LRU, since we need to track both frequency counts and recency order inside each frequency group.
*/

// Structure of DLL's Node
class Node{
    Node prev;
    int key, value;
    int freq;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList{
    Node head, tail;
    int size;

    DoublyLinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void deletionOfNode(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;

        prevNode.next = afterNode;
        afterNode.prev = prevNode;

        size--;
    }

    void insertionAfterHead(Node node){
        Node currentAfterHead = head.next;
        head.next = node;
        node.next = currentAfterHead;
        currentAfterHead.prev = node;
        node.prev =head;

        size++;
    }
}

// LFUCache
// LFU is frequency-based eviction.
// If frequencies tie, use LRU order inside that freq list.

class LFUCache {

    HashMap<Integer, DoublyLinkedList> freqMap = new HashMap<>(); // Freq, DLL List
    // Group Nodes as a single list having same frequency
    HashMap<Integer, Node> keyNodeMap = new HashMap<>(); // Key, Node
    int capacity,minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        // If keyNodeMap doesn't contains key
        if(!keyNodeMap.containsKey(key))
            return -1;
        
        // If present then take the node and return value afterwards
        Node node = keyNodeMap.get(key);
        updateNode(node); // update about node

        return node.value;
    }

    
    public void put(int key, int value) {
        
        // If key already exists in keyNodeMap
        if(keyNodeMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            node.value = value; // Update the value;
            updateNode(node);
        }else{
            if(keyNodeMap.size()==capacity){
                // Remove Least Frequently Used Node by picking the list first 
                DoublyLinkedList list = freqMap.get(minFreq); 
                Node node = list.tail.prev; // Pick the list which is having minFreq and in that list pick a node which is just prev to tail
                keyNodeMap.remove(node.key); // Delete it from keyNodeMap
                list.deletionOfNode(node); // Delete it from List 
            }

            Node node = new Node(key, value);
            keyNodeMap.put(key,node);
            minFreq = 1;

            // Check if Freq 1 have a DLL or not 
            // If we have a DLL of Freq = 1 then just insert the node after head
            // If we do not have DLL of Freq = 1 then make a new DLL and insert the node after head
            freqMap.computeIfAbsent(1, k-> new DoublyLinkedList()).insertionAfterHead(node);
        }
    }

    // updateNode - migrates a node from its old frequency list to its new frequency list
    public void updateNode(Node node){
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.deletionOfNode(node);

        if(oldFreq==minFreq && oldList.size==0){ //In DLL size is defined as field n not fun. 
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k-> new DoublyLinkedList()).insertionAfterHead(node);
        // Put the (new node freq,DLL) in freqMap
        // And insert the node after the head in the DLL 
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
