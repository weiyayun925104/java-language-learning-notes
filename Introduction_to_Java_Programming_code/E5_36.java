/*
  Use loops to simplify Programming Exercise 3.9

  Note: This is a copy of Exercise 3.9, since I'd already used loops to
  simplify the solution.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E5_36 {
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
