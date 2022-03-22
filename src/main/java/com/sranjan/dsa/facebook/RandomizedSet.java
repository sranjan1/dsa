package com.sranjan.dsa.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
	    private final List<Integer> orderedData;
	    
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        this.orderedData = new ArrayList<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	    	if(orderedData.contains(val)) return false;
	        return this.orderedData.add(val);
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	return this.orderedData.remove(Integer.valueOf(val));
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return orderedData.get(new Random().nextInt(this.orderedData.size()));
	    }
	}
