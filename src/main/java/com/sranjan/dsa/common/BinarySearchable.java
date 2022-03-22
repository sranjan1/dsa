package com.sranjan.dsa.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchable {
	public static void main(String[] args) {
		int[] unsortedNumbers = { 1, 12, 4, 7, 6, 8 };
//		List<Integer> unsortedList = new ArrayList<>();
//		unsortedList.add(e)
//		List<Integer> result = new BinarySearchable().binarySearchable(unsortedNumbers);
//		for(Integer num: result) {
//			System.out.println(num);
//		}
		List<Integer> result2 = new BinarySearchable().binarySearchableWithoutUsingArrays(unsortedNumbers);
		for (Integer num2 : result2) {
			System.out.println(num2);
		}

	}
	
	public List<Integer> binarySearchableUsingCollections(List<Integer> unsortedList) {
		
		List<Integer> binarySearchable = new ArrayList<>(unsortedList.size());
		for(Integer num : unsortedList) {
			if(Collections.binarySearch(unsortedList, num) > 0) {
				binarySearchable.add(num);
			}
		}
		return binarySearchable;
	}

	public List<Integer> binarySearchable(int[] unsortedArray) {
		List<Integer> binarySearchableNumbers = new ArrayList<>();
		for (int i = 0; i < unsortedArray.length; i++) {
			int result = Arrays.binarySearch(unsortedArray, unsortedArray[i]);
			if (result >= 0) {
				binarySearchableNumbers.add(unsortedArray[i]);
			}
		}
		return binarySearchableNumbers;
	}

	public List<Integer> binarySearchableWithoutUsingArrays(int[] unsortedArray) {
		List<Integer> unsortedList = new ArrayList<Integer>(unsortedArray.length);
		for(int num : unsortedArray) {
			unsortedList.add(num);
		}
		// 1,12,4,7,6,8
		// expected is 1,4,6,8
		List<Integer> binaryNotSearchableNumbers = new ArrayList<>();
		int left = 0;
		int right = unsortedArray.length - 1;
		int mid = 0;
		int midPointValue = 0;
		while(left < right) {
			mid = (left+right)/2;
			midPointValue = unsortedArray[mid];
			if(unsortedArray[left] > midPointValue) {
				binaryNotSearchableNumbers.add(unsortedArray[left]);
			}
			left++;
		}
		unsortedList.removeAll(binaryNotSearchableNumbers);
		return unsortedList;
	}

}
