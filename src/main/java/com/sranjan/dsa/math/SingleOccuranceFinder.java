package com.sranjan.dsa.math;

import java.util.Arrays;

public class SingleOccuranceFinder {

	public static void main(String[] args) {
		int[] nums = {1,2,1,2,1,2,4,5,5,5};
		int[] nums1 = {3,4,4,4,5,5,5};
		int[] nums2 = {1,1,1,3,3,3,8};
		int[] nums3 = {1,2,2,2,1,1,-3,4,4,4};
		System.out.println("Using Sorting Answer for middle element is single occurance is "+SingleOccuranceFinderUsingSorting(nums));
		System.out.println("Using Sorting Answer where first element is single occurance is "+SingleOccuranceFinderUsingSorting(nums1));
		System.out.println("Using Sorting Answer where last element is single occurance is "+SingleOccuranceFinderUsingSorting(nums2));		
		System.out.println("Using Sorting Answer with negative numbers where single occurance is in middle "+SingleOccuranceFinderUsingSorting(nums3));		

	}
	
	
    public static int SingleOccuranceFinderUsingSorting(int[] nums) {
    	// if only 1 element, that is the only single occurrence
    	if(nums.length == 1) return nums[0];
    	
    	//Sort
    	Arrays.sort(nums);
    	
    	int result = Integer.MAX_VALUE;//some default value
    	
    	// if single element is at the first location
    	if(nums[0] != nums[1]) return nums[0];
    	
    	// if single occurrence is the last element
    	if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length - 1];
    	
    	for(int i=0; i<nums.length-1; ) {
    		if(nums[i] == nums[i+1]) {
    			i+= 3;
    		}
    		else {
    			result = nums[i];
    			break;
    		}
    	}

        return result;
    }

}
