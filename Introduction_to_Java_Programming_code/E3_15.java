/*
  Revise Listing 3.8, Lottery.java, to generate a lottery of a three-digit
  number. The program prompts the user to enter a three-digit number and
  determines whether the user wins according to the following rules:

  1. If the user input matches the lottery number in the exact order, the
  award is $10,000.
  2. If all digits in the user input match all digits in the lottery number,
  the award is $3,000.
  3. If one digit in the user input matches a digit in the lottery number,
  the award is $1,000.
*/

import java.util.Scanner;

public class E3_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a three-digit number: ");
    String numString = input.nextLine();

    displayLotteryOutcome(numString);
  }

  private static void displayLotteryOutcome(String numString) {
    int a = Integer.parseInt(numString.charAt(0) + "");
    int b = Integer.parseInt(numString.charAt(1) + "");
    int c = Integer.parseInt(numString.charAt(2) + "");
    int x = generateLottery();
    int y = generateLottery();
    int z = generateLottery();

    StringBuilder output = new StringBuilder();

    if (a == x && b == y && c == z) {
      output.append("Matched exact order: you win $10,000");
    } else if ((a == x && c == y && b == z) ||
               (b == x && c == y && a == z) ||
               (b == x && a == y && c == z) ||
               (c == x && a == y && b == z) ||
               (c == x && b == y && a == z)) {
      output.append("All digits match: you win $3,000");
    } else if ((a == x || a == y || a == z) ||
               (b == x || b == y || b == z) ||
               (c == x || c == y || c == z)) {
      output.append("At least one digit matches: you win $1,000");
    } else {
      output.append("Too bad! You win nothing!");
    }

    System.out.println("Lottery: " + x + y + z);
    System.out.println(output);
  }

  private static int generateLottery() {
    return (int)(Math.random() * 10);
  }
}
