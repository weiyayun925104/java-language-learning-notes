/*
  If you know the balance and the annual percentage interest rate, you can
  compute the interest on the next monthly payment using the following formula:

  interest = balance x (annualInterestRate / 1200)

  Write a program that reads the balance and the annual percentage interest
  rate and displays the interest for the next month.
*/

import java.util.Scanner;

public class E2_20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter balance and interest rate (e.g. 3 for 3%): ");
    double balance = input.nextDouble();
    double percentInterestRate = input.nextDouble();

    double interest = nextMonthInterest(balance, percentInterestRate);

    System.out.println("The interest is " + interest);
  }

  private static double nextMonthInterest(double balance, double rate) {
    return balance * (rate / 1200.0);
  }
}
