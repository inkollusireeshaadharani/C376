package com.assignments.exceptionhandling;

public class OddNumber {
	
	public void checkNumber(int n) throws OddNumberException {
		if(n % 2 != 0) {
			throw new OddNumberException("You have enteredt an Odd number!");
		}
		System.out.println("Number is " + n);
	}
}

@SuppressWarnings("serial")
class OddNumberException extends Exception{
	public OddNumberException(String msg) {
		super(msg);
	}
}
