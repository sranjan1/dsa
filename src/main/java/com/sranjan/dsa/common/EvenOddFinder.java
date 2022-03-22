package com.sranjan.dsa.common;

public class EvenOddFinder {

	public static void main(String[] args) {
		System.out.println("6 is "+isEven(6));
		System.out.println("5 is "+isEven(5));
		System.out.println("13 is "+isEven(13));
		System.out.println("42 is "+isEven(42));

	}
	
	public static String isEven(int number) {
		if(number > 0 && (number & 1) == 0) {
			return "even";
		}
		return "odd";
	}
}
