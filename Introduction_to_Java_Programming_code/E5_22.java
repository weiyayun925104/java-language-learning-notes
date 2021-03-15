/*
  The monthly payment for a given loan pays the principal and the interest.
  The monthly interest is computed by multiplying the interest rate and the
  balance (the remaining principal). The principal paid for the month is
  therefore the monthly payment minus the monthly interest. Write a program
  that lets the user enter the loan amount, number of years, and interest
  rate and displays the amortization schedule for the loan.
*/

import java.util.Scanner;

public class E5_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Loan Amount: ");
    double amount = input.nextDouble();
    System.out.print("Number of Years: ");
    int years = input.nextInt();
    System.out.print("Annual Interest Rate: ");
    double annualRate = input.nextDouble();

    double monthlyRate = annualRate / 1200.0;
    double monthlyPayment = amount * monthlyRate / (1 - 1 /
      Math.pow(1 + monthlyRate, years * 12));

    System.out.println("Payment#    Interest    Principal    Balance");
    for (int i = 1; i <= years * 12; i++) {
      double interest = monthlyRate * amount;
      double principal = monthlyPayment - interest;
      amount -= principal;
      System.out.printf("%-8d    %-8.2f    %-9.2f    %-7.2f\n",
        i, interest, principal, amount);
    }
    System.out.println();
  }
}
