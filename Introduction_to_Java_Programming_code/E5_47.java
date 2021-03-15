/*
  ISBN-13 is a new standard for identifying books. It uses 13 digits. The last
  digit is a checksum, which is calculated from the other digits using the
  following formula

                                (formula)

  If the checksum is 10, replace it with 0. Your program should read the input
  as a string.
*/

import java.util.Scanner;

public class E5_47 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
    String isbnPrefixString = input.nextLine();

    if (!isValidEntry(isbnPrefixString)) {
      System.out.println(isbnPrefixString + " is an invalid input");
      System.exit(1);
    }

    // break up isbn prefix string into individual string digits
    String[] isbnPrefixStringArr = isbnPrefixString.split("");

    // convert this to new array of integer digits
    int[] isbnPrefixArr = new int[isbnPrefixStringArr.length];
    for (int i = 0; i < isbnPrefixArr.length; i++) {
      isbnPrefixArr[i] = Integer.parseInt(isbnPrefixStringArr[i]);
    }

    int checksum = checksum(isbnPrefixArr);

    System.out.println(isbnPrefixString + "" + checksum);
  }

  private static int checksum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 0) {
        sum += arr[i];
      } else {
        sum += (3 * arr[i]);
      }
    }
    int checksum = 10 - (sum % 10);
    return checksum == 10 ? 0 : checksum;
  }

  private static boolean isValidEntry(String s) {
    boolean valid = true;
    if (s.length() != 12) {
      valid = false;
    } else {
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!Character.isDigit(c)) {
          valid = false;
          break;
        }
      }
    }
    return valid;
  }
}
