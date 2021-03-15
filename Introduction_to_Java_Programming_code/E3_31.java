/*
  Write a program that prompts the user to enter the exchange rate from
  currency in US dollars to Chinese RMB. Prompt the user to enter 0 to convert
  from US dollars to Chinese RMB and 1 to convert from Chinese RMB to US
  dollars. Prompt the user to enter the amount in US Dollars or Chinese RMB
  to convert it to Chinese RMB or US dollars, respectively.
*/

import java.util.Scanner;

public class E3_31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the exchange rate from dollars to RMB: ");
    double xRate = input.nextDouble();
    System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
    int direction = input.nextInt();
    if (direction != 0 && direction != 1) {
      System.out.println("Incorrect input");
      System.exit(1);
    } else if (direction == 0) {
      System.out.print("Enter the dollar amount: ");
    } else {
      System.out.print("Enter the RMB amount: ");
    }
    double amount = input.nextDouble();

    double newCurrency = 0.0;
    if (direction == 0) {
      newCurrency = amount * xRate;
    } else {
      newCurrency = amount / xRate;
    }

    System.out.print(amount + (direction == 0 ? " dollars" : " yuan") +
      " is ");
    if (direction == 1) {
      System.out.printf("$%.2f", newCurrency);
    } else {
      System.out.printf("%.2f yuan", newCurrency);
    }
    System.out.println();
  }
}
