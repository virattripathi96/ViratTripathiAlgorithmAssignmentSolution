package com.greatlearning.service;

public class Stockers {
	int stockCount;
	double []stockPrices;
	boolean []stockTrend;
	
	public Stockers(int count, double[] stockArray, boolean[] trendArray) {
		this.stockCount = count;
		this.stockPrices = stockArray;
		this.stockTrend = trendArray;
	}
	

	public void displayStocksAsc() {
		double[] cloneArray = ArrayUtil.cloneArray(stockPrices, stockCount);
		MergeSort mergeSort = new MergeSort();
		mergeSort.applySort(cloneArray, 0, stockCount - 1);
		System.out.println("Stock prices in ascending order are :");
		ArrayUtil.printArray(cloneArray, stockCount);
	}
	
	public void displayStocksDesc() {
		double[] cloneArray = ArrayUtil.cloneArray(stockPrices, stockCount);
		MergeSort mergeSort = new MergeSort();
		mergeSort.sortArrayDesc(cloneArray, 0, stockCount - 1);
		System.out.println("Stock prices in descending order are :");
		ArrayUtil.printArray(cloneArray, stockCount);
	}
	
	public void displayRisingStockCount() {
		System.out.println("Total no of companies whose stock price rose today : " + findRisingStockCount());
	}
	
	private int findRisingStockCount() {
		int count = 0;
		for(int i = 0; i < stockCount; i++) {
			if(stockTrend[i]) {
				count++;
			}
		}
		return count;
	}
	
	public void displayFallingStockCount() {
		int count = stockCount - findRisingStockCount();
		System.out.println("Total no of companies whose stock price fell today : " + count);
	}
	
	public void searchStockPrice(double stockPrice) {
		double[] cloneArray = ArrayUtil.cloneArray(stockPrices, stockCount);
		MergeSort mergeSort = new MergeSort();
		mergeSort.applySort(cloneArray, 0, stockCount - 1);
		BinarySearch binarySearch = new BinarySearch();
		int found = binarySearch.binarySearch(cloneArray, 0, stockCount, stockPrice);
		if(found >= 0) {
			System.out.println("Stock of value " + stockPrice + " is present");
		} else {
			System.out.println("Value not found");
		}
	}

}
