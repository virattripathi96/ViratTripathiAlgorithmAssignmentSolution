package com.greatlearning.service;

public class ArrayUtil {
	public static void printArray(double array[], int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
			System.out.println("");
		}
	}
	
	public static double[] cloneArray(double array[], int size) {
		double newArray[] = new double[size];
		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
}