package com.sranjan.dsa.common;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] array = { 6, 5, 7, 4,12 };
//		bubbleSort(array);
		for (int num : mergeSort(array)) {
			System.out.println(num);
		}
	}

	public static void bubbleSort2(int[] array) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped == true);
	}

	public static void bubbleSort(int[] array) {
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = 0; j < arrayLength - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			int key = array[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}
	
	public static int[] mergeSort (int[] array) {
		if(array == null || array.length < 2) {
			return array;
		}
		int midPoint = array.length/2;
		int[] leftArray = new int[midPoint];
		int[] rightArray = new int[array.length - midPoint];
		for(int i = 0; i< midPoint; i++) {
			leftArray[i] = array[i];
		}
		for(int i=0; i< rightArray.length; i++) {
			rightArray[i] = array[midPoint++];
		}
		return mergeSortedArrays(mergeSort(leftArray), mergeSort(rightArray));
	}

	private static int[] mergeSortedArrays(int[] left, int[] right) {
		
		int[] finalSortedArray = new int[left.length + right.length];
		int i = 0,j = 0,k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				finalSortedArray[k++] = left[i++];
			} else {
				finalSortedArray[k++] = right[j++];
			}
		}
		
		while(i<left.length) {
			finalSortedArray[k++] = left[i++];
		}
		
		while (j < right.length) {
			finalSortedArray[k++] = right[j++];
		}
		return finalSortedArray;
	}
	
	
	public static int[] quickSort(int[] array) {
		if(array.length < 2) {
			return array;
		}
		
		int pivot = array[array.length - 1];
		int[] left = new int[array.length - 1];
		int[] right = new int[array.length - 1];
		for(int i=0;i<array.length - 1;i++) {
			if(array[i] < pivot) {
				left[i] = array[i];
			}else {
				right[i] = array[i];
			}
		}
		
		
		
		return array;
	}
	
	
	
	
	
	
	
}
