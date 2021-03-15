/*
  Write a recursive method that parses a hex number as a string into a decimal
  integer. The method header is:

  public static int hex2Dec(String hexString)

  Write a test program that prompts the user to enter a hex string and displays
  its decimal equivalent.
*/

import java.util.Scanner;

public class E18_24 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a hex string: ");
    String hexString = input.nextLine().toLowerCase();

    System.out.println(hex2Dec(hexString));
  }

  public static int hex2Dec(String hexString) {
    return hex2Dec(hexString, hexString.length() - 1, 1, 0);
  }

  public static int hex2Dec(
    String hexString, int position, int hexFactor, int value) {
    if (position < 0) { return value; }
    int hexDigit = getDecimalValue(hexString.charAt(position));
    value += hexDigit * hexFactor;
    return hex2Dec(hexString, position - 1, hexFactor * 16, value);
  }

  private static int getDecimalValue(char hexChar) {
    if (Character.isDigit(hexChar)) {
      return Integer.parseInt(String.valueOf(hexChar));
    }

    int digit = 0;
    switch (hexChar) {
      case 'a': digit = 10; break;
      case 'b': digit = 11; break;
      case 'c': digit = 12; break;
      case 'd': digit = 13; break;
      case 'e': digit = 14; break;
      case 'f': digit = 15;
    }

    return digit;
  }
}
