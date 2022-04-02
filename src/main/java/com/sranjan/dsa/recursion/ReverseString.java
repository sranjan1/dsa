package com.sranjan.dsa.recursion;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println("After reversing");
        for(char ch: s) {
            System.out.println(ch);
        }
    }

    public static void reverseString(char[] s) {
        for(int i=0, j= s.length-1; i<j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
