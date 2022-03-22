package com.sranjan.dsa.common;

/**
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * @author sumit
 *
 */

public class MoveZeroes {

	public static void main(String[] args) {
//		int[] nums = {0,1,0,3,12};
		int[] nums = {1};
		new MoveZeroes().moveZeroes(nums);
		for(int num: nums) {
			System.out.println(num);
		}

	}

	public void moveZeroes(int[] nums) {
		int anchor = 0;
		for(int explorer =0; explorer < nums.length; explorer++) {
			if(nums[explorer] != 0) {
				int temp = nums[explorer];
				nums[explorer] = nums[anchor];
				nums[anchor] = temp;
				anchor++;
			}
		}
	}

}
