package com.assignments.controlflow;

public class WhileLoop {

	public static void main(String[] args) {
		int n = 121;
		int tempn = n;
		int rev = 0;
		while(n!=0) {
			int temp = n%10;
			rev = rev*10 + temp;
			n=n/10;
		}
		if(tempn==rev)
			System.out.println(true);
		else
			System.out.println(false);
	}

}
