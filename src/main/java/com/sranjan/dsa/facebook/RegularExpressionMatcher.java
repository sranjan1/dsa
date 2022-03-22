package com.sranjan.dsa.facebook;

public class RegularExpressionMatcher {
	
	public static void main(String...args) {
		System.out.println(new RegularExpressionMatcher().isMatch("Hello", "Hel"));
		
	}
	
    public boolean isMatch(String s, String p) {
    	boolean isMatch = false;
    	final Character DOT = '.';
    	final Character ASTERIX = '*';
    	
    	
    	if(s == null || p == null) {
    		return isMatch;
    	}
   
    	for(int i=0;i<p.length();i++) {
    		for(int j=0; j<s.length();j++) {
    			if(p.charAt(j)!= s.charAt(i) && p.charAt(i) !=DOT) {
    				isMatch = false;
    				break;
    			}
    		}
    	}
    	return isMatch;
    }

}
