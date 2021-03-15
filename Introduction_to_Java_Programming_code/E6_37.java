/*
  Write a method with the following header to format the integer with the
  specified width.

  public static String format(int number, int width)

  The method returns a string for the number with one or more prefix 0s. The
  size of the string is the width. For example, format(34, 4) returns 0034 and
  format(34, 5) return 00034. If the number is longer than the width, the
  method returns the string representation of the number. For example,
  format(34, 1) returns 34.

  Write a test program that prompts the user to enter a number and its width
  and displays a string returned by invoking format(number, width).
*/

import java.util.Scanner;

public class E6_37 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer and its width: ");
    int number = input.nextInt();
    int width = input.nextInt();

    String formattedNumber = format(number, width);

    System.out.println(formattedNumber);
  }

  public static String format(int number, int width) {
    StringBuilder s = new StringBuilder(number + "");
    if (s.length() < width) {
      int padding = width - s.length();
      for (int i = 0; i < padding; i++) {
        s.insert(0, "0");
      }
    }
    return s.toString();
  }
}
