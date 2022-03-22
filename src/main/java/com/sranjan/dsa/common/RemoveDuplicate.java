package com.sranjan.dsa.common;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1,1,2,2,3,3,4,4,5 };
//		new RemoveDuplicate().removeDuplicates(nums);
		new RemoveDuplicate().removeDuplicatesUsingTwoPointers(nums);
	}

	public int removeDuplicates(int[] nums) {
		Set<Integer> set = new HashSet<Integer>(nums.length, 0.75f);
		for (int num : nums) {
			set.add(Integer.valueOf(num));
		}
		System.out.println(set);
		return set.size();
	}
	
	public int removeDuplicatesUsingTwoPointers(int[] nums) {
		int i=0;
		for(int j=1; j<nums.length; j++) {
			if(nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
}
