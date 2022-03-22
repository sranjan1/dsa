package com.sranjan.dsa.common;

import java.util.HashSet;
import java.util.Set;

public class SubstringExample {
	
	public static void main(String[] args) {
		String str = "au";
		for(int i=0;i<str.length();i++) {
			for (int j=i+1;j<str.length();j++) {
				String substr = str.substring(i, j);
				if(hasUniqueChars(substr) ) {
					System.out.println("i= "+i+" j= "+j+" String is "+substr);
				}
			}
		}
	}
	
	private static boolean hasUniqueChars(String s) {
		Set<Character> uniqueChars = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			uniqueChars.add(s.charAt(i));
		}
		return uniqueChars.size() == s.length();
	}

}
