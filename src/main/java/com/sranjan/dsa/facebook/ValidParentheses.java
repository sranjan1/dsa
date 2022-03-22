package com.sranjan.dsa.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses instance = new ValidParentheses();
		System.out.println(instance.isValidUsingOnlyPrimitives("[]()"));
		System.out.println(instance.isValidUsingOnlyPrimitives("{[]}"));

	}

	public boolean isValidUsingOnlyPrimitives(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
			case '{':
			case '[':
			case '(':
				stack[head++] = c;
				break;
			case '}':
				if (head == 0 || stack[--head] != '{')
					return false;
				break;
			case ')':
				if (head == 0 || stack[--head] != '(')
					return false;
				break;
			case ']':
				if (head == 0 || stack[--head] != '[')
					return false;
				break;
			}
		}
		return head == 0;
	}


	public boolean isValid(String s) {
		if (s == null || s == "" || s.length() < 2) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character cr = s.charAt(i);
			if (cr == '(' || cr == '[' || cr == '{') {
				stack.push(cr);
			} else {
				if (stack.isEmpty())
					return false;
				if (cr == ')' && stack.peek() != '(')
					return false;
				if (cr == ']' && stack.peek() != '[')
					return false;
				if (cr == '}' && stack.peek() != '{')
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public boolean isValid2(String s) {
		Map<Character, Character> lookupMap = new HashMap<>();
		lookupMap.put('(', ')');
		lookupMap.put('{', '}');
		lookupMap.put('[', ']');

		for (int i = 0; i < s.length(); i = i + 2) {
			Character currentChar = s.charAt(i);
			Character expectedNextChar = lookupMap.get(currentChar);
			Character actualNextChar = s.charAt(i + 1);
			if (actualNextChar != expectedNextChar) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidParentheses(String s) {
		Stack<Character> sk = new Stack<>();
		for (char cr : s.toCharArray()) {
			if (cr == '(' || cr == '[' || cr == '{') {
				sk.push(cr);
			} else {
//	                if(sk.isEmpty()) return false;
				if (cr == ')' && sk.peek() != '(')
					return false;
				if (cr == ']' && sk.peek() != '[')
					return false;
				if (cr == '}' && sk.peek() != '{')
					return false;
				sk.pop();
			}
		}
		return sk.isEmpty();
	}

}
