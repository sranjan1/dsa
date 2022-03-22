package com.sranjan.dsa.facebook;

public class NumberSystemConverter {
	
	public static void main(String...args) {
		System.out.println(new NumberSystemConverter().toOctal(-154));
		System.out.println(Integer.toOctalString((-154)));
	}
	
	public String toHexa(int num) {
		char[] hexaTable = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		StringBuilder hexaValue = new StringBuilder();
		for(;num !=0; num >>>= 4) {
			hexaValue.append(hexaTable[num & 15]); 
		}
		return hexaValue.reverse().toString();
	}
	
	public String toOctal(int num) {
		char[] octalTable = {'0','1','2','3','4','5','6','7'};
		StringBuilder octalValue = new StringBuilder();
		for(; num !=0; num >>>=3) {
			octalValue.append(octalTable[num & 7]); 
		}
		return octalValue.reverse().toString();
	}
	
	public String toBinary(int num) {
		StringBuilder binaryString = new StringBuilder();
		while(num > 0) {
			
		}
		return binaryString.toString();
	}
	
	
	
	
}
