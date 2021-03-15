/*
  Modify Listing 2.10, ComputeChange.java, to display nonzero denominations
  only, using singular words for single units such as 1 dollar and 1 penny,
  and plural words for more than one unit such as 2 dollars and 3 pennies.
*/

import java.util.Scanner;

public class E3_07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an amount in double, for example 11.56: ");
    double amount = input.nextDouble();

    int remainingAmount = (int)(amount * 100);
    int[] denominations = new int[5];

    denominations[0] = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;
    denominations[1] = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;
    denominations[2] = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;
    denominations[3] = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;
    denominations[4] = remainingAmount;



    System.out.println("Your amount " + amount + " consists of");
    for (int i = 0; i < denominations.length; i++) {
      if (denominations[i] > 0) {
        int value = denominations[i];
        String denominationName = denominationName(i, value);
        System.out.println("    " + value + " " + denominationName);
      }
    }
  }

  private static String denominationName(int denom, int value) {
    StringBuilder output = new StringBuilder();

    if (value == 0) {
      output.append("");
    } else {
      switch (denom) {
        case 0: output.append(value > 1 ? "dollars" : "dollar"); break;
        case 1: output.append(value > 1 ? "quarters" : "quarter"); break;
        case 2: output.append(value > 1 ? "dimes" : "dime"); break;
        case 3: output.append(value > 1 ? "nickels" : "nickel"); break;
        case 4: output.append(value > 1 ? "pennies" : "penny"); break;
      }
    }

    return output.toString();
  }
}
