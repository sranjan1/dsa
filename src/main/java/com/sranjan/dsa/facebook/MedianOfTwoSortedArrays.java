package com.sranjan.dsa.facebook;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	
	public static void main(String...args) {
		
	}
	
	
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int arr1size = nums1.length;
    	int arr2size = nums2.length;
    	int finalArraySize = arr1size + arr2size;
    	double median;
    	int[] finalArray = new int[finalArraySize];
    	System.arraycopy(nums1, 0, finalArray, 0, arr1size);  
    	System.arraycopy(nums2, 0, finalArray, arr1size, arr2size);  
    	Arrays.sort(finalArray);
    	//if size is odd, median is middle element
    	//if size is even, median is mean of middle 2 numbers
    	if(finalArraySize % 2 != 0) {
    		median = (double)(finalArray[finalArraySize/2]);
    	}
    	else {
    		median = (double)(finalArray[(finalArraySize - 1) / 2] + finalArray[finalArraySize / 2]) / 2.0;
    	}
        return median;
    }

}
