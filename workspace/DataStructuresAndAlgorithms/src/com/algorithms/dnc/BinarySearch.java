package com.algorithms.dnc;

public class BinarySearch {
	public static boolean recursiveSearch(int[] arr, int s, int e, int target) {
		if(s>e) {
			return false;
		}
		int m = (s+e)/2;
		
		if(arr[m]==target) {
			return true;
		}
		else if(target<arr[m]) {
			return recursiveSearch(arr, s, m-1, target);
		}
		else {
			return recursiveSearch(arr, m+1, e, target);
		}
		
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,23,45,67,89,90};
		System.out.println(recursiveSearch(arr,0,arr.length-1,1));
	}

}
