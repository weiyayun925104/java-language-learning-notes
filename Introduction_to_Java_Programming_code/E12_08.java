/*
  Exercise 12.6 implements the hex2Dec method to throw a NumberFormatException
  if the string is not a hex string. Define a custom exception called
  HexFormatException. Implement the hex2Dec method to throw a
  HexFormatException if the string is not a hex string.
*/

import java.util.Scanner;

public class E12_08 {
  public static void main(String[] args) throws HexFormatException {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();

    System.out.println("The decimal value for hex number " + hex + " is " +
      hexToDecimal(hex.toUpperCase()));
  }

  public static int hexToDecimal(String hex) throws HexFormatException {
    for (int i = 0; i < hex.length(); i++) {
      char c = hex.charAt(i);
      if (!(c >= 'A' && c <= 'F') && !(c >= '0' && c <= '9')) {
        throw new HexFormatException("Characters in input must be 0-9 and A-F");
      }
    }

    int decimalValue = 0;
    for (int i = 0; i < hex.length(); i++) {
      char hexChar = hex.charAt(i);
      decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
    }
    return decimalValue;
  }

  public static int hexCharToDecimal(char ch) {
    if (ch >= 'A' && ch <= 'F') {
      return 10 + ch - 'A';
    } else {
      return ch -= '0';
    }
  }
}
