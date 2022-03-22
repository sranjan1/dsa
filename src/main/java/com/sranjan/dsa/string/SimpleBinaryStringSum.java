package com.sranjan.dsa.string;

public class SimpleBinaryStringSum {

	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";
		System.out.println(new SimpleBinaryStringSum().addBinary(a, b));

	}
    public String addBinary(String a, String b) {
    	Integer num1 = Integer.parseInt(a,2);
    	Integer num2 = Integer.parseInt(b,2);
    	Integer sum = num1 + num2;
    	return Integer.toBinaryString(sum);
    }
}
