package main.java.datastructure;

public class Stack {
    Node top;
    Node bottom;
    int length;

    public Stack() {
        this.length = 0;
    }

    public Stack(int data) {
        this.length = 0;
        top = new Node(data);
        bottom = top;
    }

    public int peek() {
        return top.data;
    }

    public void push(int data) {
        if (length == 0) {
            top = new Node(data);
            this.length++;
        }
        else {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            System.err.println("Stack is empty!");
            return Integer.MIN_VALUE;
        }
        int data = top.data;
        top = top.next;
        return data;
    }
}
