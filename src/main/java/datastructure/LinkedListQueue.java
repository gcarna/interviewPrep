package main.java.datastructure;


public class LinkedListQueue implements Queue {
    Node head;
    Node tail;
    int length;

    public LinkedListQueue() {
        this.length = 0;
    }

    public void enqueue (int data) {
        if (length == 0) {
            this.head = new Node(data);
            this.tail = head;
        }
        else {
            this.tail.next = new Node(data);
            this.tail  = this.tail.next;
        }
        length++;
    }

    public int dequeue () {
        if (length == 0) {
            throw new Error("Empty List");
        }
        if (length == 1) {
            int tmp = head.data;
            this.tail = null;
            this.head = null;
            this.length--;
            return tmp;
        }
        int tmp = head.data;
        head = head.next;
        length--;
        return tmp;

    }

    public int peek() {
        return head.data;
    }
}
