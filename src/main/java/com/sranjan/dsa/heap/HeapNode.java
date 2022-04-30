package com.sranjan.dsa.heap;

public class HeapNode {
    int val;
    HeapNode left;
    HeapNode right;

    public HeapNode(int val, HeapNode left, HeapNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}