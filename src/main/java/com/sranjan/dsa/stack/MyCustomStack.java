package com.sranjan.dsa.stack;

public class MyCustomStack<T> {
    private T[] stackStore;
    private int size;

    public MyCustomStack(int maxSize) {
        this.stackStore = (T[])new Object[maxSize];
        this.size = 0;
    }

    public void push(T object) {
        if(object == null)
            return;
        stackStore[stackStore.length - 1] = object;
    }

    public T pop() {
        return null;
    }

    private boolean ensureCapacity() {
        return true;

    }



}
