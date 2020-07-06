import java.util.concurrent.ExecutionException;

public class LinkedListImp<T>{
    public class Node{
        T data;
        Node next;
        // Node Constructor
        public Node(T data){
            this.data = data;
            this.next = null;
        }
        // Node Accessor Methods
        public T getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
        // Node Mutator Methods
        public void setData(T data) {
            this.data = data;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private Node cursor;

    public LinkedListImp(){
        head = null;
        tail = null;
        cursor = null;
    }

    public void printList(){
        Node pointer = head;
        while(pointer != null){
            System.out.print(pointer.getData().toString()+ " --> ");
            pointer = pointer.getNext();
        }
        System.out.println("NULL");
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }
    public int size(){
        if(isEmpty()){
            return 0;
        }
        Node pointer = head;
        int size = 0;
        while(pointer != null){
            pointer = pointer.getNext();
            size++;
        }
        return size;
    }

    public void pushFront(T data){
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }
    public T topFront(){
        return head.getData();
    }
    public void popFront(){
        if (isEmpty()){
            return;
        }
        head = head.getNext();
    }

    public void pushBack(T data){
        Node node = new Node(data);
        if(isEmpty()){
            head = tail = node;
            return;
        }
        Node pointer = head;
        while(pointer.getNext() != null){
            pointer = pointer.getNext();
        }
        pointer.setNext(node);
        tail = node;
    }
    public T topBack(){
        return tail.getData();
    }
    public void popBack(){
        if(isEmpty()){
            return;
        }
        Node pointer = head;
        while(pointer.getNext().getNext() != null){
            pointer = pointer.getNext();
        }
        tail = pointer;
        pointer.setNext(null);

    }

    public boolean find(T data){
        if(isEmpty()){
            return false;
        }
        Node pointer = head;
        while(pointer != null){
            if(pointer.getData().equals(data)){
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    public void erase(T data){
        if(isEmpty()){
            return;
        }
        if(head.getData().equals(data)){
            popFront();
            return;
        }

        Node pointer = head;
        Node prev = null;
        while(pointer != null){
            if(data.equals(pointer.getData())){
                prev.setNext(pointer.getNext());
            }
            prev = pointer;
            pointer = pointer.getNext();
        }
    }

    public void addBefore(T node, T data){
        Node newNode = new Node(data);
        if (isEmpty()){
            return;
        }
        if(head.getData().equals(node)){
            newNode.setNext(head);
            head = newNode;
            return;
        }
        Node pointer = head;
        while(!pointer.getNext().getData().equals(node)){
            pointer = pointer.getNext();
        }
        newNode.setNext(pointer.getNext());
        pointer.setNext(newNode);
    }

    public void addAfter(T node, T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            return;
        }
        if(head.getData().equals(node)){
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            return;
        }
        Node pointer = head;
        while(!pointer.getData().equals(node)){
            pointer = pointer.getNext();
        }
        newNode.setNext(pointer.getNext());
        pointer.setNext(newNode);
    }

    public void deleteAtIndex(int index){
        if(isEmpty()){
            return;
        }
        if(index == 0){
            popFront();
            return;
        }
        Node pointer = head;
        int temp = 0;
        while(temp < index-1){
            pointer = pointer.getNext();
            temp++;
        }
        pointer.setNext(pointer.getNext().getNext());
    }

    public T valueAtIndex(int index){
        if(isEmpty()){
            System.out.print("List is Empty!");
        }
        if(index == 0){
            return head.getData();
        }
        Node pointer = head;
        int temp = 0;
        while(temp < index){
            pointer = pointer.getNext();
            temp++;
        }
        if (pointer == null || index > temp){
            throw new IndexOutOfBoundsException("Out of Bounds Bro!");

        }
        return pointer.getData();
    }
    public void reverseList(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public T nthFromEnd(int pos){
        Node pointer  = head;
        int length  = 0;
        while(pointer != null){
            pointer = pointer.getNext();
            length++;
        }
        pointer = head;
        int temp = 0;
        while(temp < length - pos){
            pointer = pointer.getNext();
            temp++;
        }
        return pointer.getData();
    }
}
