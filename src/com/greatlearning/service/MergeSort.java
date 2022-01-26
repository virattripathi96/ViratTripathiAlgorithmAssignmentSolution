package com.greatlearning.service;

public class MergeSort {
	public void sortArray(double array[], int left, int right) {
		if(left >= right) {
			return;
		}
		int mid = (left + right)/2;
		sortArray(array, left, mid);
		sortArray(array, mid+1, right);
		merge(array, left, mid, right);
	}
	
	public void merge(double array[], int left, int mid, int right) {
		// find size of left and right subarrays
		// Create temporary arrays -> init, copy data
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;
		double leftSubArray[] = new double[leftArraySize], 
			rightSubArray[] = new double[rightArraySize];
		for(int i = 0; i < leftArraySize; i++) {
			leftSubArray[i] = array[left + i];
		}
		for(int i = 0; i < rightArraySize; i++) {
			rightSubArray[i] = array[mid + i + 1];
		}
		int i = 0, j = 0, k = left;
		while(i < leftArraySize && j < rightArraySize) {
			if(leftSubArray[i] < rightSubArray[j]) {
				array[k] = leftSubArray[i];
				i++;
			} else {
				array[k] = rightSubArray[j];
				j++;
			}
			k++;
		}
		while(i < leftArraySize) {
			array[k] = leftSubArray[i];
			i++; k++;
		}
		while(j < rightArraySize) {
			array[k] = rightSubArray[j];
			j++; k++;
		}
		
	}
	
	
	public void applySort(double array[], int left, int right) {
		if(left >= right) {
			System.out.println("Invalid left and right parameters");
			return;
		}
		sortArray(array, left, right);
	}
	
	private void reverseArray(double array[], int size) {
		int i = 0;
		while(i < size / 2) {
			double temp = array[i];
			array[i] = array[size - i - 1];
			array[size - i - 1] = temp;
			i++;
		}
	}
	
	public void sortArrayDesc(double array[], int left, int right) {
		sortArray(array, left, right);
		reverseArray(array, right + 1);
	}
}
