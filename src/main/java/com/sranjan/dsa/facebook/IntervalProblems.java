package com.sranjan.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalProblems {

	public static void main(String[] args) {
		
		int[][] intervals = {{1,2}, {3,5}, {6,7},{8,10}, {12,16}};
		int[] newInterval = {4,8};
		int[][] result = new IntervalProblems().insert(intervals, newInterval);
		
		int[][] mergeIntervals = {{1,3},{2,6}, {7,15},{8,10}, {15,18}};
		int[][] mergeResult = new IntervalProblems().merge(mergeIntervals);
		
		

	}

    public int[][] insert(int[][] intervals, int[] newInterval) {
    	if(intervals == null || intervals.length == 0) {
    		return new int[][] {{newInterval[0], newInterval[1]}};
    	}
    	
    	List<int[]> finalIntervals = new ArrayList<>();
    	for(int[] interval : intervals) {
    		if(interval[1] < newInterval[0]) {
    			finalIntervals.add(interval);
    		}else if(newInterval[1] < interval[0]) {
    			finalIntervals.add(newInterval);
    			newInterval = interval;
    		} else {
    			 newInterval[0] = Math.min(newInterval[0], interval[0]);
                 newInterval[1] = Math.max(newInterval[1], interval[1]);
    		}
    	}
    	finalIntervals.add(newInterval);
    	return finalIntervals.toArray(new int[finalIntervals.size()][]);
        
    }
	
	
    public int[][] merge(int[][] intervals) {
    	//edge case
    	if(intervals == null || intervals.length < 2) {
    		return intervals;
    	}
    	Arrays.sort(intervals, new java.util.Comparator<int[]>() {
    	    public int compare(int[] a, int[] b) {
    	        return Integer.compare(a[0], b[0]);
    	    }
    	});
    	List<int[]> results = new ArrayList<>();
    	int[] baseInterval = intervals[0];
    	for(int i = 1; i< intervals.length; i++) {
    		//Check if there is any overlap
    		if(baseInterval[1] < intervals[i][0]) {
    			results.add(baseInterval);	
    			baseInterval = intervals[i];
    		} else {
    			baseInterval[1] = Math.max(baseInterval[1], intervals[i][1]);  
    		}
    	}
    	results.add(baseInterval);
    	return results.toArray(new int[results.size()][]);
    }
}
