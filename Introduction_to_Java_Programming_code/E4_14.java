/*
  Write a program that prompts the user to enter a letter grade A, B, C, D, E,
  or F and displays its corresponding numeric value 4, 3, 2, 1, or 0.
*/

import java.util.Scanner;

public class E4_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a letter grade: ");
    String grade = input.nextLine();

    if (!isValidGrade(grade)) {
      System.out.println(grade + " is an invalid grade");
      System.exit(1);
    }

    System.out.println("The numeric value for grade " + grade + " is " +
      valueForGrade(grade));
  }

  private static int valueForGrade(String grade) {
    char c = grade.toLowerCase().charAt(0);
    int value = -1;
    switch (c) {
      case 'a': value = 4; break;
      case 'b': value = 3; break;
      case 'c': value = 2; break;
      case 'd': value = 1; break;
      case 'f': value = 0;
    }
    return value;
  }

  private static boolean isValidGrade(String grade) {
    boolean valid = true;
    String sLC = grade.toLowerCase();
    if (sLC.length() != 1) {
      valid = false;
    } else {
      char c = sLC.charAt(0);
      if (c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'f') {
        valid = false;
      }
    }
    return valid;
  }
}
