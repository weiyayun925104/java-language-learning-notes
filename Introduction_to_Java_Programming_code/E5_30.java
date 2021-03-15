/*
  Suppose you save $100 each month into a savings account with the annual
  interest rate 5%. So, the monthly interest rate is 0.05 / 12 = 0.00417. After
  the first month, the value in the account becomes

      100 * (1 + 0.00417) = 100.417

  After the second month, the value in the account becomes

      (100 + 100.417) * (1 + 0.00417) = 201.252

  After the third month, the value in the account becomes

      (100 + 201.252) * (1 + 0.00417) = 302.507

  and so on.
  
  Write a program that prompts the user to enter an amount (eg 100), the annual
  interest rate (eg 5), and the number of months (eg 6) and displays the
  amount in the savings account after each month.
*/

import java.util.Scanner;

public class E5_30 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the monthly savings amount: ");
    double monthlySavings = input.nextDouble();
    System.out.print("Enter the annual interest rate: ");
    double annualInterestRate = input.nextDouble();
    System.out.print("Enter the number of months: ");
    int months = input.nextInt();

    double monthlyInterestRate = annualInterestRate / 1200.0;

    double balance = 0.0;
    for (int i = 1; i <= months; i++) {
      balance += monthlySavings;
      balance *= (1 + monthlyInterestRate);
      System.out.printf("Month %d: $%.2f\n", i, balance);
    }
    System.out.println();
  }
}
