package com.sranjan.dsa.common;

public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = {3, 6, 1, 0,14};
		int indexFound = new LargestNumber().dominantIndex(nums);
		System.out.println("Found the number at index "+indexFound);
	}
	
    public int dominantIndex(int[] nums) {
    	//edge case
    	if(nums.length == 1) {
    		return 0;
    	}
    	int max = 0;
    	int index = 0;
    	
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i] > max) {
    			max = nums[i];
    			index = i;
    		}
    	}
    	for(int i= 0; i<nums.length; i++) {
    		if(nums[i] != max && nums[i]*2 > max) {
    			return -1;
    		}
    	}
    	return index;
    }
}
