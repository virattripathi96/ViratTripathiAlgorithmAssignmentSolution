package com.greatlearning.service;

public class BinarySearch {
	public int findKey(double[] array, double key, int size) {
		int pivot = findPivot(array, 0, size - 1);
		if(pivot == -1) {
			return binarySearch(array, 0, size - 1, key);
		}
		if(array[pivot] == key) {
			return pivot;
		}
		if(array[0] <= key) {
			return binarySearch(array, 0, pivot-1, key);
		} else {
			return binarySearch(array, pivot + 1, size - 1, key); 
		}
		
	}

	public int binarySearch(double[] array, int low, int high, double key) {
		if(high < low) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if(array[mid] == key) {
			return mid;
		} else if(array[mid] < key) {
			return binarySearch(array, mid + 1, high, key);
		} 
		return binarySearch(array, low, mid - 1, key);
	}

	private int findPivot(double[] array, int low, int high) {
		if(high < low) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if(mid < high && array[mid] > array[mid + 1]) {
			return mid;
		} else if (mid > low && array[mid] < array[mid - 1]) {
			return mid - 1;
		} else if(array[low] <= array[mid]){
			return findPivot(array, mid + 1, high);
		}
			
		return findPivot(array, low, mid - 1);
	}
	
}
