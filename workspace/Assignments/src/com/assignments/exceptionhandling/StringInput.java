package com.assignments.exceptionhandling;

import java.util.Scanner;

public class StringInput {
	
	public void takeInput() throws VowelNotFoundException{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str = s.nextLine();
		s.close();
		if(!containsVowels(str)) {
			throw new VowelNotFoundException("String doesn't contain at least one vowel");
		}
		System.out.println("You entered: "+str);
	}
	
	public boolean containsVowels(String str) {
		str = str.toLowerCase();
		for(char ch : str.toCharArray()) {
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				return true;
			}	
		}
		return false;		
	}
}

@SuppressWarnings("serial")
class VowelNotFoundException extends Exception{
	public VowelNotFoundException(String msg) {
		super(msg);
	}
}
