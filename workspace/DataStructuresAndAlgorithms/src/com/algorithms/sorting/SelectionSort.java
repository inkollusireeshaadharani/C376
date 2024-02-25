package com.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	public void sort(int[] arr) {
		System.out.println("Initial array: "+Arrays.toString(arr));
		for(int i = 0; i < arr.length ; i++) {			
				int minIndex = findMinIndex(arr,i,arr.length-1);
				swap(arr,minIndex,i);
//				System.out.println("After pass "+(i+1)+" "+Arrays.toString(arr));
		}
		System.out.println("After sorting array: "+Arrays.toString(arr));
	}
	public int findMinIndex(int[] arr, int beg, int end) {
		int min = arr[beg];
		int minIndex = beg;
		for(int i = beg;i<=end;i++) {
			if(arr[i]<min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] =arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args) {
//		int[] arr = new int[]{66,44,99,11,33};
		int[] arr = new int[]{9,3,7,5,2};
		new SelectionSort().sort(arr);
//		System.out.println(Arrays.toString(arr));
	}

}
