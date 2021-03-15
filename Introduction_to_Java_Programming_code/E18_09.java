/*
  Write a recursive method that displays a string reversely on the console
  using the following header:

  public static void reverseDisplay(String value)

  For example, reverseDisplay("abcd") displays dcba. Write a test program that
  prompts the user to enter a string and displays its reversal.
*/

import java.util.Scanner;

public class E18_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    reverseDisplay(s);
    System.out.println();
  }

  public static void reverseDisplay(String value) {
    reverseDisplay(value, value.length() - 1);
  }

  public static void reverseDisplay(String value, int index) {
    if (index >= 0) {
      System.out.print(value.charAt(index));
      reverseDisplay(value, index - 1);
    }
  }
}
