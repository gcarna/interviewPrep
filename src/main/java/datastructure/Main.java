package main.java.datastructure;

public class Main {
    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();

        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.insert(0, 10);

        System.out.println(linkedList.head.data);


    }
}
