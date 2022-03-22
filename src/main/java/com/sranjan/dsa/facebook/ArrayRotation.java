package com.sranjan.dsa.facebook;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 21;
		new ArrayRotation().rotate(nums, k);

		for (int n : nums) {
			System.out.println(n);
		}
	}

	public void rotate2(int[] nums, int k) {
		if (k < 0 || nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Invalid inputs");
		}
		if (k % nums.length == 0) {
			// no rotation is required
			return;
		}
		k %= nums.length;

		int[] copy = Arrays.copyOf(nums, nums.length);

		while (k > 0) {
			nums[0] = nums[nums.length - 1];
			for (int i = 1; i < nums.length; i++) {
				nums[i] = copy[i - 1];
			}
			k--;
			copy = Arrays.copyOf(nums, nums.length);
		}
	}

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
