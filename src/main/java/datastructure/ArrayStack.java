package main.java.datastructure;

import java.util.EmptyStackException;

public class ArrayStack {
    int[] stackArray;
    int length;
    int MAX_SIZE;

    public ArrayStack(int MAX_SIZE) {

        this.length = 0;
        this.MAX_SIZE = MAX_SIZE;
        this.stackArray = new int[MAX_SIZE];
    }

    void push(int data){

        if (this.length >= MAX_SIZE){
            throw new StackOverflowError();
        }

        stackArray[length++] = data;

    }

    int pop(){

        if (length == 0) {
           throw new EmptyStackException();
        }

        return this.stackArray[--length];

    }

    int peek() {
        if (length > 0) return stackArray[length - 1];
        else throw new EmptyStackException();
    }
}

