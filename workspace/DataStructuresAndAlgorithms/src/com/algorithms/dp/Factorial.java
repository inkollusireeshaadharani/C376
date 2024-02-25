package com.algorithms.dp;

public class Factorial {
	public static int recursiveFind(int n) {
		if(n==1) {
			return 1;
		}
		return n * recursiveFind(n-1);
	}
	public static int memoFind(int n,int[] memo) {
		if(memo[n]!=0) {
			System.out.println("Entered memo");
			return memo[n];
		}
		return memo[n]= n * memoFind(n-1,memo); 
	}
	public static int iterativeFind(int n) {
		int fact = 1;
		for(int i = n;i > 0 ; i--) {
			fact *= i;
		}
		return fact;
	}
	public static void main(String[] args) {
		int[] memo = new int[5+1];
		memo[1] = 1;
		System.out.println(memoFind(5,memo));
	}
}
