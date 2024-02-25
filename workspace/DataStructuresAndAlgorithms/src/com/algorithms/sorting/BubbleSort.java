package com.algorithms.sorting;

import java.util.Arrays;

	public class BubbleSort {
	public void sort(int[] arr) {
		System.out.println("Initial array: "+Arrays.toString(arr));
		for(int i = 0; i < arr.length ; i++) {			
				for(int j = 1; j < (arr.length - i);j++) {
					if(arr[j-1]>arr[j]) {
						swap(arr,j,j-1);
					}
				}
				System.out.println("After pass "+(i+1)+" "+Arrays.toString(arr));
		}
		System.out.println("After sorting array: "+Arrays.toString(arr));
	}
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] =arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{30,87,21,34,32,11,90,67,105};
		new BubbleSort().sort(arr);
	}

}
