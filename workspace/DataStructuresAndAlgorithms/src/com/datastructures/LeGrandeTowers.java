package com.datastructures;

import java.util.Arrays;

import com.datastructures.impl.MyCircularDoubleLinkedList;
import com.datastructures.impl.MyDoublyLinkedList;

public class LeGrandeTowers {

	public static void main(String[] args) {
		int[] apart = new int[] {650,345,290,825,120,50};
		int n = apart.length;
		int[] contr = new int[n];
		for(int i = 0;i<n;i++) {
			contr[i]=apart[(i+1)%n] + apart[(i+2)%n];
		}
		System.out.println(Arrays.toString(contr));
//		
//		using CLL
//		
		MyDoublyLinkedList<Integer> mdll = new MyCircularDoubleLinkedList<>();
		mdll.add(650);
		mdll.add(345);
		mdll.add(290);
		mdll.add(825);
		mdll.add(120);
		mdll.add(50);
		
		for(int i = 0;i<mdll.size();i++) {			
			System.out.println(mdll.get(i+1)+mdll.get(i+2));
		}
		
	}

}
