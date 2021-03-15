/*
  Write a program that reads in investment amount, annual interest rate,
  and number of years, and displays the future investment value using the
  following formula:

  futureInvestmentValue = investmentAmount *
      (1 + monthlyInterestRate)^(numberOfYears * 12)

  For example, if you enter amount 1000, annual interest rate 3.25%, and number
  of years 1, the future investment value is 1032.98.
*/

import java.util.Scanner;

public class E2_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter investment amount: ");
    double investmentAmount = input.nextDouble();
    System.out.print("Enter annual interest rate in percentage: ");
    double annualPercentInterestRate = input.nextDouble();
    System.out.print("Enter number of years: ");
    double numberOfYears = input.nextInt();

    double futureValue = futureInvestmentValue(investmentAmount,
      annualPercentInterestRate, numberOfYears);

    System.out.printf("Accumulated value is $%.2f\n", futureValue);
  }

  private static double futureInvestmentValue(double amount, double rate,
    double years) {
    double mRate = rate / 1200.0;
    return amount * Math.pow(1 + mRate, years * 12);
  }
}
