package com.sranjan.dsa.common;

/**
 * 
 * Input: nums = [1,7,3,6,5,6]
   Output: 3
   Explanation:
   The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
   Also, 3 is the first index where this occurs.
 * 
 * 
 * @author sumit
 *
 */
public class PivotIndex {

	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		System.out.println(new PivotIndex().pivotIndex(nums));
	}
	
    public int pivotIndex(int[] nums) {
    	//handle edge case
    	if(nums.length == 0) {
    		return -1;
    	}
    	int leftSum = 0;
    	int totalSum = 0;
    	
    	for(int num : nums) {
    		totalSum += num;
    	}
    	for (int i=0; i<nums.length; i++) {
    		if(leftSum == (totalSum - nums[i])) {
    			return i;
    		}
    		else {
    			leftSum += nums[i];
    			totalSum -= nums[i];
    		}
    	}
    	
    	return -1;
    }

}
