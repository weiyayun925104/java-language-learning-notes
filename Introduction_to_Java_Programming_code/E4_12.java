/*
  Write a program that prompts the user to enter a hex digit and displays its
  corresponding binary number.
*/

import java.util.Scanner;

public class E4_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a hex digit: ");
    String hex = input.nextLine().toLowerCase();

    if (!isValidEntry(hex)) {
      System.out.println("Invalid entry. Must be 0-9, A-F.");
      System.exit(1);
    }

    System.out.println(hexToBin(hex));
  }

  private static String hexToBin(String hex) {
    return decToBin(hexToDec(hex));
  }

  private static String decToBin(int dec) {
    StringBuilder bin = new StringBuilder();
    do {
      bin.insert(0, dec % 2);
      dec /= 2;
    } while (dec != 0);
    return bin.toString();
  }

  private static int hexToDec(String hex) {
    int dec = -1;
    char c = hex.charAt(0);
    if (Character.isDigit(c)) {
      dec = Integer.valueOf(hex);
    } else {
      switch (c) {
        case 'a': dec = 10; break;
        case 'b': dec = 11; break;
        case 'c': dec = 12; break;
        case 'd': dec = 13; break;
        case 'e': dec = 14; break;
        case 'f': dec = 15;
      }
    }
    return dec;
  }

  private static boolean isValidEntry(String s) {
    boolean valid = true;
    char c = s.charAt(0);
    boolean digit = Character.isDigit(c);
    boolean letter = Character.isLetter(c);

    if (s.length() != 1) {
      valid = false;
    } else if (digit && (c < '0' || c > '9')) {
      valid = false;
    } else if (letter && (c < 'a' || c > 'f')) {
      valid = false;
    }

    return valid;
  }
}
