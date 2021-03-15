/*
  Write a recursive method that displays an int value reversely on the console
  using the following header:

  public static void reverseDisplay(int value)

  For example, reverseDisplay(12345) displays 54321. Write a test program that
  prompts the user to enter an integer and displays its reversal.
*/

import java.util.Scanner;

public class E18_08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();

    reverseDisplay(n);
    System.out.println();
  }

  public static void reverseDisplay(int value) {
    if (value > 0) {
      System.out.print(value % 10);
      reverseDisplay(value / 10);
    }
  }
}
