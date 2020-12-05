package src.datastructure;

public class LinkedList {
    Node head = null;
    Node tail = null;
    int length;

    public LinkedList(int data) {
        this.length = 0;
        this.append(data);
    }

    public LinkedList() {
        this.length = 0;
    }


    public void append(int data){
        Node newNode = new Node(data);
        if (this.head == null && this.tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        this.length++;
    }

    public void prepend(int data){
        Node newNode = new Node(data);
        if (this.head == null && this.tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        this.length++;
    }

    public void insert(int index, int data){
        if(index >= length) this.append(data);
        else if (index == 0) this.prepend(data);
        else {
            Node newNode = new Node(data);
            Node current = this.head;
            while (current.next != null && index > 1){
                current = current.next;
                index--;
            }
            newNode.next = current.next;
            current.next = newNode;

        }
        this.length++;

    }

}
