package com.sranjan.dsa.common;

public class ReplaceElements {

	public static void main(String[] args) {
		int[] arr = {17,18,5,4,6,1};
		Timer.startTimer();
		new ReplaceElements().replaceElements(arr);
		Timer.stopTimer();
		System.out.println("Time taken is :"+Timer.getDurationInMicros());
		for (int num: arr) {
			System.out.println(num);
		}
	}
	
    public int[] replaceElements(int[] arr) {
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = findMaxNumberToRight(arr, i);
    	}
    	return arr;
    }
    
    private int findMaxNumberToRight(int[] arr, int currentIndex) {
    	if(currentIndex == arr.length - 1) {
    		return -1;
    	}
    	int max = 0;
    	
    	for(int j=currentIndex+1; j<arr.length; j++) {
    		if(arr[j] > max) {
    			max = arr[j];
    		}
    	}
    	return max;    	
    }
}
