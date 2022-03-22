package com.sranjan.dsa.facebook;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("au"));
		LongestSubstringWithoutRepeatingCharacters obj1 = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstringUsingBruteForce("au"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int maxLength = 0;
		Set<Character> uniqueChars = new HashSet<>();
		while (i < s.length()) {
			char c = s.charAt(i);
			if (!uniqueChars.contains(c)) {
				uniqueChars.add(c);
				maxLength = Math.max(maxLength, i - j + 1);
				i++;
			} else {
				uniqueChars.remove(s.charAt(j++));
			}
		}
		return maxLength;
	}
	
	
	public int lengthOfLongestSubstringUsingBruteForce(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int i = 0;
		int j = 0;
		int maxLength = 0;
		for(i=0;i<s.length();i++) {
			for (j=i+1;j<s.length();j++) {
				String substr = s.substring(i, j);
				if(hasUniqueChars(substr) ) {
					maxLength = Math.max(maxLength, substr.length());
				}
			}
		}
		return maxLength;
	}
	
	private boolean hasUniqueChars(String s) {
		Set<Character> uniqueChars = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			uniqueChars.add(s.charAt(i));
		}
		return uniqueChars.size() == s.length();
	}
}
