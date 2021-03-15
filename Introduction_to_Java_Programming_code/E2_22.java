/*
  Rewrite Listing 2.10, ComputeChange.java, to fix the possible loss of
  accuracy when converting a double value to an int value. Enter the input
  as an integer whose last two digits represent the cents. For example,
  the input 1156 represents 11 dollars and 56 cents.
*/

import java.util.Scanner;

public class E2_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an amount in int, for example 1156 " +
      "(11 dollars and 56 cents): ");
    int amount = input.nextInt();

    int remainingAmount = amount;

    int numberOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;
    int numberOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;
    int numberOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;
    int numberOfNickels = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;
    int numberOfPennies = remainingAmount;

    System.out.println("Your amount " + amount + " consists of");
    System.out.println("    " + numberOfOneDollars + " dollars");
    System.out.println("    " + numberOfQuarters + " quarters");
    System.out.println("    " + numberOfDimes + " dimes");
    System.out.println("    " + numberOfNickels + " nickels");
    System.out.println("    " + numberOfPennies + " pennies");
  }
}
