package com.sranjan.dsa.common;

/**
 *
 * Input: [1,0,2,3,0,4,5,0] Output: null Explanation: After calling your
 * function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * 
 * @author sumit
 *
 */

public class DuplicateZeros {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
		new DuplicateZeros().duplicateZeros(arr);
		for (int num : arr) {
			System.out.println(num);
		}
	}

	public void duplicateZeros(int[] arr) {
		StringBuilder builder = new StringBuilder();

		for (int num : arr) {
			if (num == 0) {
				builder.append(num);
			}
			builder.append(num);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(builder.substring(i, i + 1));
		}
	}
}
