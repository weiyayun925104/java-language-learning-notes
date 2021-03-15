/*
  Write a recursive method that converts a decimal number into a hex number as
  a string. The method header is:

  public static String dec2Hex(int value)

  Write a test program that prompts the user to enter a decimal number and
  displays its hex equivalent.
*/

import java.util.Scanner;

public class E18_22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int value = input.nextInt();

    System.out.println(dec2Hex(value));
  }

  public static String dec2Hex(int value) {
    // Because the recursive method breaks when the value becomes zero through
    // repeated division by 16, we need a separate hook to ensure that when the
    // user enters "0", it will actually be returned in hex, rather than an
    // empty string.
    boolean startingValueIsZero = (value == 0);
    return dec2Hex(value, "", startingValueIsZero);
  }

  public static String dec2Hex(
    int value, String hexString, boolean startingValueIsZero) {
    if (startingValueIsZero) {
      return "0";
    } else {
      if (value == 0) { return hexString; }
      hexString = getHexDigit(value % 16) + hexString;
      return dec2Hex(value / 16, hexString, startingValueIsZero);
    }
  }

  private static char getHexDigit(int value) {
    if (value >= 0 && value <= 9) {
      return String.valueOf(value).charAt(0);
    }
    char ch = 0;
    switch (value) {
      case 10: ch = 'A'; break;
      case 11: ch = 'B'; break;
      case 12: ch = 'C'; break;
      case 13: ch = 'D'; break;
      case 14: ch = 'E'; break;
      case 15: ch = 'F';
    }
    return ch;
  }
}
