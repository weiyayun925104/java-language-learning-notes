/*
  Rewrite Listing 2.10, ComputeChange.java, to fix the possible loss of
  accuracy when converting a float value to an int value. Read the input as a
  string such as "11.56". Your program should extract the dollar amount before
  the decimal point and the cents after the decimal amount using the indexOf
  and substring methods.
*/

import java.util.Scanner;

public class E4_26 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an amount, for example 11.56: ");
    String entry = input.nextLine();

    if (!isValidEntry(entry)) {
      System.out.println("Invalid input.");
      System.exit(1);
    }

    int remainingAmount = getCents(entry);

    int numberOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;
    int numberOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;
    int numberOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;
    int numberOfNickels = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;
    int numberOfPennies = remainingAmount;

    System.out.println("Your amount " + entry + " consists of");
    System.out.println("    " + numberOfOneDollars + " dollars");
    System.out.println("    " + numberOfQuarters + " quarters");
    System.out.println("    " + numberOfDimes + " dimes");
    System.out.println("    " + numberOfNickels + " nickels");
    System.out.println("    " + numberOfPennies + " pennies");
  }

  private static int getCents(String entry) {
    return extractDollars(entry) * 100 + extractCents(entry);
  }

  private static int extractDollars(String entry) {
    int dollars;
    if (entry.contains(".")) {
      dollars = Integer.parseInt(entry.substring(0, entry.indexOf(".")));
    } else {
      dollars = Integer.parseInt(entry);
    }
    return dollars;
  }

  private static int extractCents(String entry) {
    int cents;
    if (entry.contains(".")) {
      cents = Integer.parseInt(entry.substring(entry.indexOf(".") + 1,
        entry.length()));
    } else {
      cents = 0;
    }
    return cents;
  }

  private static boolean isValidEntry(String entry) {
    boolean valid = true;
    try {
      double dValue = Double.parseDouble(entry);
      if (dValue < 0) {
        valid = false;
      }
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }
}
