package com.sranjan.dsa.common;

public class NeedleHaystack {

	public static void main(String[] args) {

	}
	
    public int strStr(String haystack, String needle) {
    	if(needle == null || haystack == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	if(needle.isEmpty()) {
    		return 0;
    	}
    	if(haystack.contains(needle)) {
    		return haystack.indexOf(needle);
    	}
        return -1;
    }
}
