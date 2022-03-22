package com.sranjan.dsa.common;

import java.util.Arrays;

public class CheckDoubleExists {

	public static void main(String[] args) {
		int[] arr = {-3,-4,10,-19,4,6,-8};
		Timer.startTimer();
		boolean result = new CheckDoubleExists().checkIfExist(arr);
		Timer.stopTimer();
		System.out.println("function returned : "+result+ " and time taken :"+Timer.getDurationInMicros());
//	
//		boolean result = new CheckDoubleExists().isEven(4);

//		System.out.println("function returned : "+result+ " and time taken :"+Timer.getDurationInMicros());
		
		
	}

	public boolean checkIfExist(int[] arr) {
		Arrays.sort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			if(isEven(arr[i])) {
				int result = Arrays.binarySearch(arr,(i+arr.length-1)/2, arr.length, arr[i] * 2);
				if (result >= 0 && result != i) {
					return true;
				}
			}
		}
		return false;
	}
	
    public boolean checkIfExist3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isEven(arr[i])) {
                if (linearSearch(arr, arr.length, arr[i] / 2, i)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isEven(int num) {
        return (num & 1) == 0;
    }
    
    private boolean linearSearch(int[] array, int length, int element, int currentIndex) {
        // Check for edge cases
        if (array == null || length == 0) {
            return false;
        }

        // Check each element starting from the first one
        for (int i = 0; i < length; i++) {
            if (i == currentIndex) continue;
            // We found the element at index i, so return true.
            if (array[i] == element) {
                return true;
            }
        }

        // We didn't find the element in the array.
        return false;
    }	
}
