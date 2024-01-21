package com.assignments.controlflow;

public class DoWhileLoop {

	public static void main(String[] args) {
		int n = 10;
		int i = 1;
		int prev1 = 0;
		int prev2 = 1;
		int curr = 0;
		do {		
			System.out.println(curr);
			curr = prev1+prev2;
			prev1 = prev2;
			prev2 = curr;
			i++;
		}while(i<=n);
	}

}
