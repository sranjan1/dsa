package com.sranjan.dsa.common;

public class ReverseWords {

	public static void main(String[] args) {
		String s = "    Hello     World!   ";
		String s2 = new ReverseWords().reverseWords(s);
		System.out.println(s2);
	}

	public String reverseWords(String s) {
		String trimmedString = s.trim();
		String[] strArray = trimmedString.split("\\s+");
		for(String str: strArray) {
			System.out.println(str);
		}
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = strArray.length - 1; i >= 0; i--) {
			if (!strArray[i].isEmpty()) {
				sb.append(strArray[i]);
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}
}
