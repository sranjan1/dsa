package com.sranjan.dsa.facebook;

import java.util.Arrays;

public class KClosestPoints {

	public static void main(String[] args) {
		int[][] points = {{1,3},{-2,2}};
		int k = 1;
		int[][] answer = new KClosestPoints().kClosest(points, k);
		for(int[] arr: answer) {
			
		}

	}

	
    public int[][] kClosest(int[][] points, int k) {
    	if(points == null || points.length < k) {
    		throw new IllegalArgumentException("Invalid Input, Array should have atleast K points");
    	}
    	if(k == points.length) {
    		return points;
    	}
    	
    	int[][] result = new int[k][2];
    	double[] distance = new double[points.length];
    	
    	for(int i = 0; i<points.length;i++) {
    		double distanceToCentre = getDistance(points[i]);
    		distance[i] = distanceToCentre;
    	}
    	Arrays.sort(distance);
    	double maxDistance = distance[k-1];
    	int j = 0;
    	for(int i = 0; i< points.length; i++ ) {
    		if(getDistance(points[i]) <= maxDistance) {
    			result[j++] = points[i];
    		}
    	}
    	return result;
    }
    
    
    private double getDistance(int[] point) {
    	return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
    
    
    
}
