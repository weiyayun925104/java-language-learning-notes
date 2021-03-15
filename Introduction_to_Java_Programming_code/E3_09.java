/*
  An ISBN-10 (International Standard Book Number) consists of 10 digits. The
  last digit is a checksum which is calculated from the other nine digits using
  the following formula:

                    (formula)

  If the checksum is 10, the last digit is denoted as X according to the
  ISBN-10 convention. Write a program that prompts the user to enter the first
  9 digits and displays the 10-digit ISBN (including leading zeros). Your
  program should read the input as an integer.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E3_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first 9 digits of an ISBN as integer: ");
    String digitString = input.nextLine();

    ArrayList<Integer> digits = new ArrayList<>();
    for (int i = 0; i < digitString.length(); i++) {
      int digit = Integer.parseInt(digitString.charAt(i) + "");
      digits.add(digit);
    }

    String isbn = digitString + isbnChecksum(digits);

    System.out.println("The ISBN-10 number is " + isbn);
  }

  private static String isbnChecksum(ArrayList<Integer> digits) {
    int checksum = 0;
    for (int i = 0; i < digits.size(); i++) {
      checksum += digits.get(i) * (i + 1);
    }
    checksum %= 11;

    StringBuilder output = new StringBuilder();
    if (checksum == 10) {
      output.append("X");
    } else {
      output.append(checksum);
    }

    return output.toString();
  }
}
