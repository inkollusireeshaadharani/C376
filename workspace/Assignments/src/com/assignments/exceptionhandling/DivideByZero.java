package com.assignments.exceptionhandling;

public class DivideByZero {

	public void divide() {
		int a = 10, b = 0;
		try {
			System.out.println(a/b);
		}
		catch(ArithmeticException e) {
			System.out.println("DO NOT DIVIDE BY ZERO!");
		}
	}
}
