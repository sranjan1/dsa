package com.sranjan.dsa.common;

public class SimpleBinaryStringSum {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(new SimpleBinaryStringSum().addBinary(a, b));

	}
    public String addBinary(String a, String b) {
    	Integer num1 = Integer.parseInt(a,2);
    	System.out.println("num1 is "+num1);
    	Integer num2 = Integer.parseInt(b,2);
    	System.out.println("num2 is "+num2);
    	Integer sum = num1 + num2;
    	System.out.println("Sum is "+sum);
    	return Integer.toBinaryString(sum);
    }
}
