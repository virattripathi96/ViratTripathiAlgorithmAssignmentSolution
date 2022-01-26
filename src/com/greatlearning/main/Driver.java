package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.service.*;

public class Driver {
	static Stockers stockers;
	public static void main(String[] args) {
		System.out.println("enter the no of companies");
		Scanner sc = new Scanner(System.in);
		
		// input user data
		int companiesCount = sc.nextInt();
		double companyStockPrices[] = new double[companiesCount];
		boolean companyStockTrend[] = new boolean[companiesCount];
		
		for(int company = 1; company <= companiesCount; company++) {
			System.out.println("Enter the stock price of company " + company);
			companyStockPrices[company - 1]  = sc.nextDouble();
			
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			companyStockTrend[company - 1] = sc.nextBoolean(); 
		}
		System.out.println("_________________________");
		
		// initialize stockers object and handle operation selected by user
		int operation = 1;
		stockers = new Stockers(companiesCount, companyStockPrices, companyStockTrend);
		
		do {
		System.out.println("Enter the operation you want to perform \n"
				+ "1. Display the companies stock prices in ascending order \n"
				+ "2. Display the companies stock prices in descending order \n"
				+ "3. Display the total no of companies for which stock prices rose today \n"
				+ "4. Display the total no of companies for which stock prices declined today \n"
				+ "5. Search a specific stock price \n"
				+ "6. press 0 to exit");
		System.out.println("_________________________");
		operation = sc.nextInt();
		handleOperation(operation, sc);
		} while(operation != 0);
		
	}

	private static void handleOperation(int operation, Scanner sc) {
		switch(operation) {
		case 1: stockers.displayStocksAsc(); 
				break;
		case 2: stockers.displayStocksDesc(); 
				break;
		case 3: stockers.displayRisingStockCount(); 
				break;
		case 4: stockers.displayFallingStockCount(); 
				break;
		case 5: searchStockPrice(sc);
				break;
		case 0: System.out.println("Exited successfully");
			break;
		
		default: System.out.println("Invalid choice. Please try again"); 
			break;
		}
		
	}

	private static void searchStockPrice(Scanner sc) {
		System.out.println("enter the key value");
		double value = sc.nextDouble();
		stockers.searchStockPrice(value);
		
	}

}
