package com.sranjan.dsa.facebook;

public class ArrayOperations {
	
	public static void main(String...args) {
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(new ArrayOperations().removeDuplicates(nums));
		
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return 1;
		}
		int dupes = 0;
		for(int i=1;i <nums.length;i++) {
			if(nums[i] == nums[i-1]) {
				dupes++; 
			}
			nums[i-dupes] = nums[i];
		}
		return nums.length - dupes;
	}
	
	
	public int subarraySum(int[] nums, int targetSum) {
		int result = 0;
		
		if(nums == null || nums.length == 0) {
			return result;
		}
		
		
		
		
		
		
		return result;
		
	}

}
