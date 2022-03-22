package com.sranjan.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static void main(String...args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(new ThreeSum().threeSum(nums));
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
    	//We need minimum 3 elements in the array
    	if(nums == null || nums.length < 3) {
    		return Collections.emptyList();
    	}
    	Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++) {
        	int j = i +1;
        	int k = nums.length-1;
        	while (j<k) {
        		int sum = nums[i] + nums[j] + nums[k];
        		if(sum == 0) {
        			result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        			j++;
        			k--;
        		}
        		else if(sum > 0) {
        			k--;
        		}
        		else if (sum < 0 ) {
        			j++;
        		}
        	}
        	
        }
    	return new ArrayList<>(result);
    }	
}
