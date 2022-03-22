package com.sranjan.dsa.string;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		new ReverseString().reverseString(s);
		for(char ch : s) {
			System.out.println(ch);
		}

		
	}
    public void reverseString(char[] s) {
    	int i = 0;
    	int j = s.length-1;
    	while(i < j) {
    		char temp = s[j];
    		s[j] = s[i];
    		s[i] = temp;
    		i++;
    		j--;
    	}
    }
}
