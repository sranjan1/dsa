package com.sranjan.dsa.math;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
	List<Integer> stream;
	int size;

	public MedianFinder() {
		this.stream = new ArrayList<>();		
	}

	public void addNum(int num) {
		this.stream.add(num);
		this.size += 1;
	}

	public double findMedian() {
		return 0.0d;
	}

}
