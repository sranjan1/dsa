package com.sranjan.dsa.recursion;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(32));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(17));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(14));
    }

    public static boolean isPowerOfTwo(int n){
        return (n>0) && (n & n-1) == 0;
    }



}
