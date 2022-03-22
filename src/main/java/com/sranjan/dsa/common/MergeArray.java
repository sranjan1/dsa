package com.sranjan.dsa.common;

import java.util.Arrays;

/**
 * 
 * Input:
   nums1 = [1,2,3,0,0,0], m = 3
   nums2 = [2,5,6],       n = 3
   Output: [1,2,2,3,5,6]
 * 
 * @author sumit
 *
 */

public class MergeArray {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		new MergeArray().merge(nums1, 3, nums2, 3);
	}
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	for(int i=m,j=0; i<nums1.length && j<nums2.length; i++, j++) {
    			nums1[i] = nums2[j];
    		}
    	Arrays.sort(nums1);
    	}

    }	
