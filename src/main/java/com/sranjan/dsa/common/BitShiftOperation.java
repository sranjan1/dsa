package com.sranjan.dsa.common;

public class BitShiftOperation {
	public static void main(String...args) {
		int num = -64;
		System.out.println("Number is : "+num);
		System.out.println("After rightShift : "+rightShift(num));
		System.out.println("After unsighnedRightShift : "+unsignedRightShift(num) );
	}
	
	public static int rightShift(int num) {
		return num >> 4;
	}
	
	public static int unsignedRightShift(int num) {
		return num >>> 4;
	}
	
	
	
	public static int leftShift(int num) {
		return num << 1;
	}
	
	
	
	

}
