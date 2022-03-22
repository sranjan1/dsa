package com.sranjan.dsa.common;

public class SimpleArrayOperations {

	public static void main(String[] args) {
		
		int[] squareNumbers = new int[10];
		System.out.println(squareNumbers.length);
		
		for(int i=0; i<10; i++) {
			int square = (i+1) * (i+1);
			squareNumbers[i] = square;
		}
		
		for(int num : squareNumbers) {
			System.out.println(num);
		}
	}

}
