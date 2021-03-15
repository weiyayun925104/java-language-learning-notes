/*
  Write a program that lets the user enter the loan amount and loan period in
  number of years and displays the monthly and total payments for each
  interest rate starting from 5% to 8%, with an increment of 1/8.
*/

import java.util.Scanner;

public class E5_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Loan Amount: ");
    double amount = input.nextDouble();
    System.out.print("Number of Years: ");
    int years = input.nextInt();

    System.out.println("Interest Rate     Monthly Payment     Total Payment");
    for (double i = 5.0; i <= 8; i += 0.125) {
      double monthlyRate = i / 1200;
      double monthlyPayment = amount * monthlyRate / (1 - 1 /
        Math.pow(1 + monthlyRate, years * 12));
      double totalPayment = monthlyPayment * years * 12;
      System.out.printf("%-13.3f     %-15.2f     %-13.2f\n", i,
        monthlyPayment, totalPayment);
    }
  }
}
