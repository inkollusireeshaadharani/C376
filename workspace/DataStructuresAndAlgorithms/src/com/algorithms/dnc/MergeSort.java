package com.algorithms.dnc;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] arr,int s, int e) {
		if(s>=(e-1)) {
			return;
		}
		int m = (s+e)/2;
		sort(arr,s,m);
		sort(arr,m,e);
		merge(arr,s,m,e);
	}
	public static void merge(int[] arr,int s, int m, int e) {
		int i = s;
		int j = m;
		int k = 0;
		int[] temp = new int[e-s];
		while(i < m && j < e) {
			if(arr[i]<arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}
		while(i < m) {
			temp[k++] = arr[i++];		
		}
		while(j < e) {
			temp[k++] = arr[j++];
		}
		for(int t = 0; t < temp.length; t++) {
			arr[s+t] = temp[t];
		}
	}
	public static void main(String[] args) {
		int[] arr = {3,1,5,6,4,7,2,9};
		sort(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
