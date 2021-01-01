package main.java.datastructure;

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

    private Node traverseNode(int index){
        Node driver = head;

        while (driver != null && index > 0){
            driver = driver.next;
            index--;
        }
        return driver;
    }

    public void insert(int index, int data){
        if (index < 0) {System.err.println("Index can't be negative!"); return;}
        if(index >= length) this.append(data);
        else if (index == 0) this.prepend(data);
        else {
            Node newNode = new Node(data);
            Node runner = traverseNode(index - 1);
            newNode.next = runner.next;
            runner.next = newNode;
        }
        this.length++;
    }

    public void remove(int index){
        if (index < 0) {System.err.println("Index can't be negative!"); return; }
        if (index == 0) {
            head = head.next;
            this.length--;
        }
        else {
            Node runner = traverseNode(index - 1);

            if (runner == null && runner.next == null)  return;

            runner.next = runner.next.next;
            this.length--;
        }
    }

    public void reverse(){

        iterativeReverse();

    }

    private void iterativeReverse(){
        if (this.head == null || this.head.next == null)
            return;

        Node leader = this.head.next;
        Node follower = this.head;
        follower.next = null;

        while (leader != null){
            Node tmp = leader.next;
            leader.next = follower;
            follower = leader;
            leader = tmp;
        }
        this.head = follower;
    }

    private Node recursiveReverse(Node head){
        if (head == null || head.next == null)
        {
            return head;
        }

        Node newHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public void printList(){
        Node driver = head;
        while (driver != null){
            System.out.print(String.format("%s -> ", driver.data));
            driver = driver.next;
        }
        System.out.println("null");
    }

}
