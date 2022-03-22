package com.sranjan.dsa.common;

/**
 * 
 * Given nums = [3,2,2,3], val = 3, Your function should return length = 2, with
 * the first two elements of nums being 2. It doesn't matter what you leave
 * beyond the returned length.
 * 
 * @author sumit
 *
 */

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		System.out.println("Before removal");
		for(int n: nums) {
			System.out.println(n);
		}
		new RemoveElement().removeElement(nums, 3);
		System.out.println("After Removal");
		for(int n: nums) {
			System.out.println(n);
		}
		
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;
	}

}
