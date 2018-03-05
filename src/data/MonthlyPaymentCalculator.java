package data;

import java.util.Scanner;

public class MonthlyPaymentCalculator {
	
	public MonthlyPaymentCalculator(double price, int time, double rate) {
		this.price = price;
		this.time = time;
		this.rate = rate;
	}
	
	public double monthlyPayment() {
		// Use the following formula:
		// A * (r * (1+r)^M) / ((1+r)^M - 1)
		// Note that r refer to the interest rate for a month,
		// i.e. r = rate / 12.
		double r = rate / 12;
		return price * (r * Math.pow(1 + r, time)) / 
				(Math.pow(1 + r, time) - 1);
	}
	
	public double totalInterest() {
		double monthly = monthlyPayment();
		return monthly * time - price;
	}
	
	double price, rate;
	int time;
    
    public static void main(String []argv) {
    	// Give the user a warm greeting.
    	System.out.println("Welcom to Monthly Payment Calculator!");
    	System.out.println("Please provide following information:");
    	
    	// Input required information.
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("\n1) What is the total price of car? "
    			+ "(sticker price + taxes + extras)");
    	System.out.print("please input an integer or floating number: ");
    	double price = scanner.nextFloat();

    	System.out.println("\n2) What is the down payment?");
    	System.out.print("please input an integer or floating number: ");
    	price -= scanner.nextFloat();
    	
    	System.out.println("\n3) What is the length of loan? (in months)");
    	System.out.print("please input an integer: ");
    	int time = scanner.nextInt();
    	
    	System.out.println("\n4) What is the interest rate for loan? (for a year, "
    			+ "in decimal form, e.g., 10% for rate should be 0.1)");
    	System.out.print("please input a floating number: ");
    	double rate = scanner.nextFloat();
    	scanner.close();
    	
    	// Output result.
    	MonthlyPaymentCalculator mpc = new MonthlyPaymentCalculator(price, time, rate);
    	System.out.printf("\nYou should pay $%.3f per month.", mpc.monthlyPayment());
    	System.out.printf("\nThe total interest is $%.3f.", mpc.totalInterest());
    }
}
