package com.assignments.controlflow;

public class ForLoopTest {

	public static void main(String[] args) {
		int n = 5;
		int factorial = 1;
		for(int i = 1; i<=n;i++) {
			factorial*=i;
		}
		System.out.println(factorial);
	}

}
