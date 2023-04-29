public class LinkedList {
    
    private Node head; // pointer for the beginning of the list 
    private Node tail; // pointer for the end of the list 
    private Node curNode; 
    
    // Default constructor: set head and tail pointers to null 
    public LinkedList() {
        head = tail = null;
    }
    
    // Overloaded constructor: assigns head and tail pointers to node 
    public LinkedList(Node node) {
        this.head = node;
        this.tail = node;
    }
    
    // Accessor for head pointer 
    public Node getHead() {
        return head;
    }
    
    // Mutator for head pointer 
    public void setHead(Node node) {
        this.head = node;
    }
    
    // Accessor for tail pointer
    public Node getTail() {
        return tail;
    }
    
    // Mutator for tail pointer 
    public void setTail(Node node) {
        this.tail = node;
    }
    
    // Creates a string listing each driver and respective area on individual line
    public String toString(Node node) {
        // Start at head
        
        
       /* String masterStr = " ";
        
        // While not end of list
        while (head != null) {
            curNode = head;*/
            String str = node.obj.toString();
            /*masterStr = masterStr + str;
            
            curNode = curNode.next;
        }*/
        
        return str;
    }
    
    // Inserts a node at the end of the list 
    public void appendList(Node node) {
        
        // If the list is empty 
        if (head == null) {  
            head = tail = node; // Set the head and tail pointers to node
        }
        else {
            tail.next = node; // Set the tail's next pointer to node 
            node.prev = tail; // Set the node's previous pointer to the tail 
            tail = node; // Set the tail pointer to node 
        }
    }
    
    // Inserts a node at the beginning of the list 
    public void preprendList(Node node) {
        
        // If the list is empty 
        if (head == null) {
            head = tail = node; // Set the head and tail pointers to node 
        }
        else {
            node.next = head; // Set the node's next's pointer to head 
            head.prev = node; // Seat the head's previous pointer to the node 
            head = node; // Set (re-define) the head to the node
        }
    }

    
    // Inserts a node after a given existing list node
    public void insertAfer(Node curNode, Node node) {
        // If the list is empty
        if (head == null) {
            head = tail = node; // Set the head and tail pointers to node
        }
        // Insertion after the tail
        else if (head != null && curNode == tail) {
            tail.next = node; // Set the tail's next pointer to the node
            node.prev = tail; // Set the node's prev pointer to tail
            tail = node; // Set (re-define) the tail to the node
        }
        else {
            // sucNode = curNode.next; // Set sucNode to curNode's successor 
            node.next = curNode.next; // Set the node's next pointer to sucNode
            node.prev = curNode; // Set the node's prev pointer to curNode
            curNode.next = node; // Set curNode's next pointer to the node
            curNode = node; // Set sucNode's prev pointer to the node
        }
    }
    
    // Removes a given existing list node 
    public void removeNode(Node node) {
        // sucNode = node.next; // Set sucNode to the node's successor
       // predNode = node.prev; // Set predNode to the node's predecessor
        
        if (node.next != null) {
            node = node.prev; // Set the successor node's prev pointer to predNode
        }
        
        if (node.prev != null) {
            node = node.next; // Set the predecessor node's next pointer to sucNode
        }
        
        if (node == head) {
            head = node.next; // Remove the head 
        }
        
        if (node == tail) {
            tail = node.prev; // Remove the tail
        }
    }
    
    // Find size of list 
    public int listSize() {
        curNode = head;
        int count = 0;
        
        while (curNode != null) {
            ++count;
        }
        
        return count;
    }
    
    // Traverses the list
    public void traverseList() {
        curNode = head;
        
        while (curNode != null) {
        // code   
        }
    }
    
    // Traverse the list in reverse order 
    public void reverseTreverseList() {
        curNode = tail;
        
        while (curNode != null) {
        // code    
        }
    }
    
    // Sorts list in ascending order using insertion sort algorithm 
    public void sortList() {
        
        curNode = head.next; // Set curNode to the second list element
        
        // While not end of list 
        while (curNode != null) { 
           // nextNode = curNode.next; // set nextNode to the node at curNode's next pointer
           // searchNode = curNode.prev; // set searchNode to the node at curNode's prev pointer
            
            while (curNode.next != null && curNode.prev.obj.compareTo(curNode.obj) > 0) { 
                curNode.prev = curNode.prev.prev; // Traverse the list backeards until searchNode
                                              // is either less than curNode or null
            }
        
            removeNode(curNode); // Remove curNode from the list    
            
            if (curNode.prev == null) {
                curNode.prev = null;
                preprendList(curNode); // Insert curNode at the beginning of the list
            }
            else {
                insertAfer(curNode.prev, curNode); // Insert curNode after searchNode
            }
            
            curNode = curNode.next;
        }
    }
        
    
        
    
}