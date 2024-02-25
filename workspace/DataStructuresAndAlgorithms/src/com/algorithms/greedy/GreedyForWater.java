package com.algorithms.greedy;

import java.util.Scanner;

import com.algorithms.sorting.SelectionSort;

public class GreedyForWater {
	
	public static int findBottles(int[] bottles, int N, int X) {
		SelectionSort s = new SelectionSort();
		s.sort(bottles);
		int count = 0;
		int taken = 0;
		while(taken+bottles[count]<=X && count < N) {
			taken +=bottles[count];
			count++;
		}
		return count;
	}

	//add constraints
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of test cases: ");
		int testcases = sc.nextInt();
		for(int t = 0; t < testcases; t++) {
			System.out.println("Enter number of bottles: ");
			int N = sc.nextInt(); //num of bottles
			System.out.println("Enter capacity of container: ");
			int X = sc.nextInt(); //capacity
			System.out.println("Enter capacities of "+N+" bottles: ");
			int[] bottles = new int[N];
			for(int i = 0; i< N; i++) {
				bottles[i]=sc.nextInt();
			}
			System.out.println("\nMax number of bottles: "+findBottles(bottles,N,X)+"\n");
		}
	}

}
