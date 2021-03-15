/*
  Write a method that computes the future investment value at a given interest
  rate for a specified number of years. The future investment is determined
  using the formula in Programming Exercise 2.21.

  Use the following method header:

  public static double futureInvestmentValue(double investmentValue,
    double monthlyInterestRate, int years)

  For example, futureInvestmentValue(10000, 0.05/12, 5) returns 12833.59.

  Write a test program that prompts the user to enter the investment amount
  (eg 1000) and the interest rate (eg 9%) and prints a table that displays
  future value for the years from 1 to 30.
*/

import java.util.Scanner;

public class E6_07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("The amount invested: ");
    double investmentAmount = input.nextDouble();
    System.out.print("Annual interest rate: ");
    double annualInterestRate = input.nextDouble();

    double monthlyInterestRate = annualInterestRate / 1200.0;

    System.out.println("Years   Future Value");
    for (int i = 1; i <= 30; i++) {
      double futureValue = futureInvestmentValue(investmentAmount,
        monthlyInterestRate, i);
      System.out.printf("%-5d   %12.2f\n", i, futureValue);
    }
    System.out.println();
  }

  public static double futureInvestmentValue(double investmentAmount,
    double monthlyInterestRate, int years) {
    return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
  }
}
