package com.sranjan.dsa.common;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnes {

	private static int[] binaryArray = new int[10];

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			binaryArray[i] = new java.util.Random().nextInt(2);
		}
		for (int num : binaryArray) {
			System.out.println(num);
		}
		int result = new MaxConsecutiveOnes().countOnes(binaryArray);
		System.out.println("Result of countOnes is : "+result);
	}

	public int countOnes(int[] binaryArray) {
		int count = 0;
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		countMap.put(1, 0); //initialize
		for (int value : binaryArray) {
			if (value == 0) {
				if (count > countMap.get(1)) {
					countMap.put(1, count);
				}
				count = 0;
				continue;
			}
			count++;
		}
		if (count < countMap.get(1)) {
			count = countMap.get(1);
		}
		return count;
	}

}
