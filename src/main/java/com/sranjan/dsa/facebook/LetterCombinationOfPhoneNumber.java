package com.sranjan.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
	public static void main(String...args) {
		
		LetterCombinationOfPhoneNumber obj = new LetterCombinationOfPhoneNumber();
		List<String> result = obj.letterCombinations("23");
		for(String res: result) {
			System.out.println(res);
		}
	}
	
	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) {
			return Collections.emptyList();
		}
		Map<Integer, List<Character>> map = new HashMap<>();
		map.put(2, Arrays.asList('a','b','c'));
		map.put(3, Arrays.asList('d','e','f'));
		map.put(4, Arrays.asList('g','h','i'));
		map.put(5, Arrays.asList('j','k','l'));
		map.put(6, Arrays.asList('m','n','o'));
		map.put(7, Arrays.asList('p','q','r','s'));
		map.put(8, Arrays.asList('t','u','v'));
		map.put(9, Arrays.asList('w','x','y','z'));
		
		List<String> result = new ArrayList<>();
		recurse(digits, result,"", map, 0);
		return result;
	}
	
	public void recurse(String digits, List<String> result, String temp, Map<Integer, List<Character>> map, int index) {
		if(index == digits.length()) {
			result.add(temp);
		} else {            
			Integer ch = Character.getNumericValue(digits.charAt(index));
			List<Character> chars = map.get(ch);
			for(int i=0; i < chars.size(); i++) {
				recurse(digits, result, temp + chars.get(i), map, index + 1);
			}
		}
	}
	
	
	
	public List<String> letterCombinations3(String digits) {
		LinkedList<String> ans = new LinkedList<>();
		if(digits == null || digits.isEmpty()) {
			return ans;
		}
		String[] mapping = {"","", "abc","def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i = 0; i<digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length() == i) {
				String t = ans.remove();
				for(char s: mapping[x].toCharArray()) {
					ans.add(t+s);
				}
			}
		}
		return ans;
	}
	
	
	
	
    public List<String> letterCombinations2(String digits) {
    	if(digits == null || digits == "" )
    		return Collections.emptyList();
    
    	String digitletter[] = {"","", "abc","def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};
    	List<String> result = new ArrayList<>();
    	
    	result.add("");
    	for(int i=0;i<digits.length();i++) {
    		result = combine(digitletter[digits.charAt(i) - '0'], result);
    	}
    	return result;
    }
    
    public static List<String> combine(String digit, List<String> l) {
    	List<String> result = new ArrayList<>();
    	for(int i=0;i<digit.length();i++) {
    		for(String x: l) {
    			result.add(x+digit.charAt(i));
    		}
    	}
    	return result;
    	
    }
    
	

}
