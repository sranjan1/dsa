package com.sranjan.dsa.common;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9,9,9};
		new PlusOne().plusOne(digits);
		for (int num: digits) {
			System.out.println(num);
		}
	}

	public int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;
		return newNumber;
	}
}
