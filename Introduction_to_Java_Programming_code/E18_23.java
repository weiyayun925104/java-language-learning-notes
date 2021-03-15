/*
  Write a recursive method that parses a binary number as a string into a
  decimal integer. The method header is:

  public static int bin2Dec(String binaryString)

  Write a test program that prompts the user to enter a binary string and
  displays its decimal equivalent.
*/

import java.util.Scanner;

public class E18_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a binary string: ");
    String binaryString = input.nextLine();

    System.out.println(bin2Dec(binaryString));
  }

  public static int bin2Dec(String binaryString) {
    return bin2Dec(binaryString, binaryString.length() - 1, 1, 0);
  }

  public static int bin2Dec(
    String binaryString, int position, int binFactor, int value) {
    if (position < 0) { return value; }
    char charDigit = binaryString.charAt(position);
    value += binFactor * Integer.parseInt(String.valueOf(charDigit));
    return bin2Dec(binaryString, position - 1, binFactor * 2, value);
  }
}
