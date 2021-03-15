/*
  Suppose you save $100 each month into a savings account with the annual
  interest rate 5%. Thus, the monthly interest rate is 0.05/12 = 0.00417.
  After the first month, the value in the account becomes

  100 * (1 + 0.00417) = 100.417

  After the second month, the value in the account becomes

  (100 + 100.417) * (1 + 0.00417) = 201.252

  After the third month, the value in the account becomes

  (100 * 201.252) * (1 + 0.00417) = 302.507

  and so on.

  Write a program that prompts the user to enter a monthly saving amount and
  displays the account value after the sixth month.
*/

import java.util.Scanner;

public class E2_13 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the monthly saving amount: ");
    double monthlySavingAmount = input.nextDouble();
    double monthlyInterestRate = 0.05/12;

    double accountValue = accountValue(monthlySavingAmount, monthlyInterestRate,
      6);

    System.out.printf("After the sixth month, the account value is $%.2f\n",
      accountValue);
  }

  private static double accountValue(double savings, double rate, int months) {
    double account = 0.0;
    for (int i = 0; i < months; i++) {
      account = (account + savings) * (1 + rate);
    }
    return account;
  }
}
