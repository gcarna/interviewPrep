package main.java.datastructure;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args){

//        LinkedList linkedList = new LinkedList();
//
//        linkedList.append(1);
//        linkedList.append(2);
//        linkedList.append(3);
//        linkedList.append(4);

//        linkedList.insert(2, 4);

//
//        linkedList.reverse();
//
//        linkedList.printList();
//        linkedList.remove(1);
//        linkedList.printList();

        ArrayStack stack = new ArrayStack(3);

//        stack.push(2);
//        stack.push(3);
//        stack.push(1);
//        stack.push(1);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Queue queue = new LinkedListQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());



    }
}
