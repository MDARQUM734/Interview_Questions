class MyLinkedList {
    
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;  
    private int size;

    public MyLinkedList() {
        size = 0;
        head = null;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node curr = head;
        for(int i=0; i < index; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node curr = new Node(val);
        curr.next = head;
        head = curr;
        size++;
    }
    
    public void addAtTail(int val) {
        Node curr = new Node(val);
        if(head == null) head = curr;
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = curr;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        Node curr = new Node(val);
        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        curr.next = temp.next;
        temp.next = curr;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        if(index == 0){
            head = head.next;
        } else{
            Node temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */