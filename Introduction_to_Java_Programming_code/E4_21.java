/*
  Write a program that prompts the user to enter a Social Security number in
  the format DDD-DD-DDDD, where D is a digit. Your program should check
  whether the input is valid.
*/

import java.util.Scanner;

public class E4_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a SSN: ");
    String entry = input.nextLine();

    String result = entry + " is a valid Social Security number";
    if (!isValidEntry(entry)) {
      result = result.replace("a valid", "an invalid");
    }

    System.out.println(result);
  }

  private static boolean isValidEntry(String ssn) {
    // 1. Make sure SSN contains 3 chunks of characters separated by hyphens
    // 2. Make sure the lengths of each chunk are correct (3-2-4)
    // 3. Make sure that each chunk is an integer
    String[] ssnSplit = ssn.split("-");
    boolean valid = true;
    if (ssnSplit.length != 3) {
      valid = false;
    } else if (ssnSplit[0].length() != 3 ||
               ssnSplit[1].length() != 2 ||
               ssnSplit[2].length() != 4) {
      valid = false;
    } else if (!isInteger(ssnSplit[0]) || !isInteger(ssnSplit[1]) ||
               !isInteger(ssnSplit[2])) {
      valid = false;
    }
    return valid;
  }

  private static boolean isInteger(String s) {
    boolean integer = true;
    try {
      Integer.parseInt(s);
    } catch (Exception e) {
      integer = false;
    }
    return integer;
  }
}
