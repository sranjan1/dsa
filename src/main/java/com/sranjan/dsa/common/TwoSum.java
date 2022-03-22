package com.sranjan.dsa.common;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,5,5,11};
		int[] result = new TwoSum().twoSum(nums, 10);
		for(int num: result) {
			System.out.println(num);
		}
	}

	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length < 2) {
			throw new IllegalArgumentException("Invalid Array passed, Needs 2 numbers atleast");
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
}
