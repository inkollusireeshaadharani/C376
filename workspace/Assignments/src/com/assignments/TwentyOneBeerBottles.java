package com.assignments;

import java.util.Scanner;

public class TwentyOneBeerBottles {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ans = 0;
		int bottles = 21;
		System.out.println("Welcome");
		System.out.println("You can pick 1 to 4 bottles at once");
		System.out.println("Do you want to go first?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		ans = s.nextInt();
		if(ans==1) {
			do {
				System.out.println("How many would you like to pick up");
				int pick = s.nextInt();
				int comp = 5 - pick;
				System.out.println("You have picked "+ pick);
				System.out.println("Computer has picked "+ comp);
				bottles = bottles - pick - comp;	
				System.out.println("Bottles left "+ bottles);	
				System.out.println("====================================");
			}while(bottles!=1);
			System.out.println("Computer Won. You lost!");
		}
		
		System.out.println("Game over");
		s.close();
	}

}
